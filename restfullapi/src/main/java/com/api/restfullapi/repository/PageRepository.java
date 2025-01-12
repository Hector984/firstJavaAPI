package com.api.restfullapi.repository;

import com.api.restfullapi.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PageRepository extends JpaRepository<PageEntity, Long> {

    // Las dos sitanxis son equivalentes
    //@Query("SELECT * FROM page WHERE title = :title")

    // Se utiliza Optional porque nos ayuda a manejar el NullPointer Exception
    // en caso de que no se encuentre el registro en base de datos
    Optional<PageEntity> findByTitle(String title);
}
