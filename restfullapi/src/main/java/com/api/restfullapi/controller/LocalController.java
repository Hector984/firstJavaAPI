package com.api.restfullapi.controller;

import com.api.restfullapi.entity.Local;
import com.api.restfullapi.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    @Autowired(required=true)
    LocalService localService;

    @GetMapping("locals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @PostMapping("locals")
    public Local store(@RequestBody Local local) {
        return localService.store(local);
    }

    @PutMapping("locals/{id}")
    public Local update(@PathVariable Long id,@RequestBody Local local) {
        return localService.update(id, local);
    }

    @DeleteMapping("locals/{id}")
    public void destroy(@PathVariable Long id) {
        localService.destroy(id);
    }

    @GetMapping("localByName/{name}")
    public Optional<Local> findByName(@PathVariable String name) {
        return localService.findByName(name);
    }
}
