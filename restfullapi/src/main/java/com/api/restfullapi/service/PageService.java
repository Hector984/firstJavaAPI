package com.api.restfullapi.service;


import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.dtos.PageResponse;
import com.api.restfullapi.entity.PageEntity;

import java.util.List;

public interface PageService {

    List<PageEntity> index();
    PageResponse store(PageRequest page);
    PageResponse readByTitle(String title);
    PageResponse update(PageRequest page, String title);
    void destroy(String title);
}
