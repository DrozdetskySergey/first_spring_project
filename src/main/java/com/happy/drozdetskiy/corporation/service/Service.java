package com.happy.drozdetskiy.corporation.service;

import com.happy.drozdetskiy.corporation.controller.DTO.ControllerDTO;

import java.util.List;

public interface Service<T extends ControllerDTO> {

    void add(T ControllerDTO);

    void delete(T ControllerDTO);

    void edit(T ControllerDTO);

    List<T> getAll();
}
