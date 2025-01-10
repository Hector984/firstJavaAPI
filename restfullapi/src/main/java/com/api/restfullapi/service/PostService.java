package com.api.restfullapi.service;

import com.api.restfullapi.dtos.PageResponse;
import com.api.restfullapi.dtos.PostRequest;

public interface PostService {

    PageResponse store(PostRequest post);
    PageResponse destroy(Long id);
}
