package com.api.restfullapi.service;

import com.api.restfullapi.entity.Local;
import com.api.restfullapi.repository.LocalRepository;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImplementation implements LocalService{

    @Autowired(required=true)
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local store(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local update(Long id, Local local) {
        Local findLocal = localRepository.findById(id).get();

        if(Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            findLocal.setCode(local.getCode());
        }

        if(Objects.nonNull(local.getFloor())) {
            findLocal.setFloor(local.getFloor());
        }

        if(Objects.nonNull(local.getName())) {
            findLocal.setName(local.getName());
        }

        return localRepository.save(findLocal);
    }

    @Override
    public void destroy(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }
}
