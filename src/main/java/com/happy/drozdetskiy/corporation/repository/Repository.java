package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.repository.DTO.RepositoryDTO;

import java.util.List;

public interface Repository <T extends RepositoryDTO> {

    void add(T repositoryDTO);

    void remove(T repositoryDTO);

    void set(T repositoryDTO);

    List<T> query(Specification<T> specification);
}
