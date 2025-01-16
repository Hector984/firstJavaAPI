package com.api.restfullapi.controller;

import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.dtos.PageResponse;
import com.api.restfullapi.entity.PageEntity;
import com.api.restfullapi.service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController // used to expose RESTfull
@RequestMapping(path = "page")
@AllArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping
    public List<PageEntity> index() {
        return this.pageService.index();
    }

    @GetMapping(path="{title}")
    public ResponseEntity<PageResponse> show(@PathVariable String title) {
        return ResponseEntity.ok(this.pageService.readByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PageRequest pageRequest) {

        pageRequest.setTitle(this.normalizeTitle(pageRequest.getTitle()));

        final var uri = this.pageService.store(pageRequest).getTitle();

        // Como buenas practicas se regresa la uri del recurso recien creado
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping(path="{title}")
    public ResponseEntity<PageResponse> update(@PathVariable String title, @RequestBody PageRequest pageRequest) {

        return ResponseEntity.ok(this.pageService.update(pageRequest, title));
    }

    @DeleteMapping(path="{title}")
    public ResponseEntity<Void> destroy(@PathVariable String title) {
        this.pageService.destroy(title);
        return ResponseEntity.noContent().build();
    }

    private String normalizeTitle(String title) {
        if(title.contains(" ")) {
            return title.replaceAll(" ", "-");
        }

        return title;
    }
}
