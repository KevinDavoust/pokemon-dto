package com.example.DTO.dto_example.service;

import com.example.DTO.dto_example.dto.RoleDto;
import com.example.DTO.dto_example.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper {

    public RoleDto TransformRoleEntityInRoleDto(Role role)
    {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        roleDto.setId(role.getId());
        roleDto.setUserName(role.getUsers().get(0).getName());

        return roleDto;
    }

    public Role TransformRoleDtoInRoleEntity(RoleDto roleDto)
    {
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setId(roleDto.getId());

        return role;
    }
}
