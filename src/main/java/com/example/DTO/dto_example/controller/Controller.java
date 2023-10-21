package com.example.DTO.dto_example.controller;

import com.example.DTO.dto_example.service.RoleMapper;

public class Controller {

    private final RoleMapper roleMapper;

    public Controller(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
