package com.witos.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.witos.common.mybatisplus.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
import com.witos.system.api.domain.SysUser;

/**
 * 用户表 数据层
 *
 * @author witos
 */
public interface SysUserMapper extends BaseMapperX<SysUser>
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    IPage<SysUser> selectUserList(Page page,@Param("query") SysUser sysUser);
    /**
     * 根据条件查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
     List<SysUser> selectUserList(@Param("query") SysUser sysUser);

    /**
     * 根据条件分页查询已配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
     IPage<SysUser> selectAllocatedList(Page page,@Param("query") SysUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    IPage<SysUser> selectUnallocatedList(Page page,@Param("query") SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
     @InterceptorIgnore(tenantLine = "1")
     SysUser selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
     SysUser selectUserById(Long userId);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
     int insertUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
     int updateUser(SysUser user);

    /**
     * 修改用户头像
     *
     * @param userName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
     int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * 重置用户密码
     *
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
     int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
     int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
     int deleteUserByIds(Long[] userIds);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
     @InterceptorIgnore(tenantLine = "1")
     SysUser checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
     SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
     SysUser checkEmailUnique(String email);


    /**
     * 批量删除用户信息-根据租户
     *
     * @param ids 需要删除的租户ID
     * @return 结果
     */
    @InterceptorIgnore(tenantLine = "1")
    int deleteUserByTenantId(Long[] ids);
}
