package com.api.restfullapi.service;

import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.dtos.PageResponse;
import com.api.restfullapi.dtos.PostResponse;
import com.api.restfullapi.entity.PageEntity;
import com.api.restfullapi.repository.PageRepository;
import com.api.restfullapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final UserRepository userRepository;

    @Override
    public List<PageEntity> index() {

        List<PageEntity> pages = new ArrayList<PageEntity>();

        this.pageRepository.findAll().forEach(page -> pages.add(page));

        return pages;
    }

    @Override
    public PageResponse store(PageRequest page) {

        final var entity = new PageEntity();
        BeanUtils.copyProperties(page, entity);

        final var user = this.userRepository.findById(page.getUserId()).orElseThrow();

        entity.setDateCreation(LocalDateTime.now());
        entity.setUser(user);
        entity.setPosts(new ArrayList<>());

        var pageCreated = this.pageRepository.save(entity);

        final var response = new PageResponse();

        BeanUtils.copyProperties(pageCreated, response);

        return response;
    }

    @Override
    public PageResponse readByTitle(String title) {

        final var pageResponse = this.pageRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Title not found"));

        final var response = new PageResponse();

        BeanUtils.copyProperties(pageResponse, response);

        final List<PostResponse> postResponses = pageResponse.getPosts()
                .stream()
                .map(postE ->
                        PostResponse.builder()
                                .img(postE.getImg())
                                .content(postE.getContent())
                                .dateCreation(postE.getDateCreation())
                                .build()
                )
                .toList();

        response.setPosts(postResponses);

        return response;
    }

    @Override
    public PageResponse update(PageRequest page, String title) {

        final var findPage = this.pageRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Title not found"));

        findPage.setTitle(page.getTitle());

        var pageUpdated = this.pageRepository.save(findPage);

        final var response = new PageResponse();

        BeanUtils.copyProperties(pageUpdated, response);

        return response;
    }

    @Override
    public void destroy(String title) {

        if(this.pageRepository.existsByTitle(title)) {
            log.info("The page was found and deleted");
            this.pageRepository.deleteByTitle(title);
        } else {
            log.error("Error when deleting");
            throw new IllegalArgumentException("Cannot delete the page");
        }
    }
}
