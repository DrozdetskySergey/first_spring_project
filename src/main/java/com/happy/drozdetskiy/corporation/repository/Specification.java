package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.repository.DTO.RepositoryDTO;

public interface Specification<T extends RepositoryDTO> {

    boolean specified(T repositoryDTO);
}
