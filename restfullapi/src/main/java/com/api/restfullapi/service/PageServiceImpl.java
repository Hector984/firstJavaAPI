package com.api.restfullapi.service;

import com.api.restfullapi.dtos.PageRequest;
import com.api.restfullapi.dtos.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PageServiceImpl implements PageService {
    @Override
    public PageResponse store(PageRequest page) {
        return null;
    }

    @Override
    public PageResponse readByTitle(String title) {
        return null;
    }

    @Override
    public PageResponse update(PageRequest page, String title) {
        return null;
    }

    @Override
    public void destroy(String title) {

    }
}
