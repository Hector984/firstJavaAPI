package com.api.restfullapi.repository;

import com.api.restfullapi.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<PageEntity, Long> {
}
