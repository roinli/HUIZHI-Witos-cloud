package com.witos.system.service;

import com.witos.system.api.domain.SysUser;

import java.util.Set;

 public interface ISysPermissionService
{
    /**
     * 获取角色数据权限
     *
     * @param userId 用户Id
     * @return 角色权限信息
     */
    Set<String> getRolePermission(SysUser user);

    /**
     * 获取菜单数据权限
     *
     * @param userId 用户Id
     * @return 菜单权限信息
     */
    Set<String> getMenuPermission(SysUser user);
}
