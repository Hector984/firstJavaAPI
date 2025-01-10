package com.api.restfullapi.service;


import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.dtos.PageResponse;

public interface PageService {

    PageResponse store(PageRequest page);
    PageResponse readByTitle(String title);
    PageResponse update(PageRequest page, String title);
    void destroy(String title);
}
