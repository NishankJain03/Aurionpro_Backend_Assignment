package com.aurionpro.bankapp.mapper;

import com.aurionpro.bankapp.dto.RoleDto;
import com.aurionpro.bankapp.entity.Role;

public class RoleMapper {
	public static Role toRoleMapper(RoleDto roleDto) {
		Role role = new Role();
		role.setRoleName(roleDto.getRoleName());
		return role;
	}

	public static RoleDto toRoleDtoMapper(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleId(role.getRoleId());
		roleDto.setRoleName(role.getRoleName());
		return roleDto;
	}
}
