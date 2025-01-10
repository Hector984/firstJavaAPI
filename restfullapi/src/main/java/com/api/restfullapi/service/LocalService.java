package com.api.restfullapi.service;

import com.api.restfullapi.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    List<Local> findAllLocals();
    Local store(Local local);
    Local update(Long id, Local local);
    void destroy(Long id);
//    Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local> findByName(String name);
}
