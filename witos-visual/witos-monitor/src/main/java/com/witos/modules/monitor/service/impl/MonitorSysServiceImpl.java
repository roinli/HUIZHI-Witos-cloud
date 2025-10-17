package com.witos.modules.monitor.service.impl;

import java.util.List;

import com.witos.common.core.web.domain.AjaxResult;
import com.witos.modules.monitor.mapper.MonitorSysInfoMapper;
import com.witos.modules.monitor.utils.LinuxStateForShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.witos.modules.monitor.mapper.MonitorSysMapper;
import com.witos.modules.monitor.domain.MonitorSys;
import com.witos.modules.monitor.service.IMonitorSysService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.witos.common.core.text.Convert;
import com.witos.common.core.utils.ServletUtils;
import com.witos.common.mybatisplus.constant.MybatisPageConstants;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务器管理Service业务层处理
 *
 * @author witos
 * @date 2022-04-26
 */
@Service
public class MonitorSysServiceImpl implements IMonitorSysService
{
    @Autowired
    private MonitorSysMapper monitorSysMapper;

    @Autowired
    private MonitorSysInfoMapper monitorSysInfoMapper;

    /**
     * 查询服务器管理
     *
     * @param id 服务器管理主键
     * @return 服务器管理
     */
    @Override
    public MonitorSys selectMonitorSysById(Long id)
    {
        return monitorSysMapper.selectById(id);
    }

    /**
     * 查询服务器管理列表-分页
     *
     * @param monitorSys 服务器管理
     * @return 服务器管理
     */
    @Override
    public IPage<MonitorSys> selectMonitorSysPage(MonitorSys monitorSys)
    {
        Page mpPage =new Page(Convert.toLong(ServletUtils.getParameterToInt(MybatisPageConstants.PAGE_NUM),1L)
                ,Convert.toLong(ServletUtils.getParameterToInt(MybatisPageConstants.PAGE_SIZE),10L));
        return monitorSysMapper.selectMonitorSysList(mpPage,monitorSys);
    }
    /**
     * 查询服务器管理列表
     *
     * @param monitorSys 服务器管理
     * @return 服务器管理
     */
    @Override
    public List<MonitorSys> selectMonitorSysList(MonitorSys monitorSys)
    {
        return monitorSysMapper.selectMonitorSysList(monitorSys);
    }

    /**
     * 新增服务器管理
     *
     * @param monitorSys 服务器管理
     * @return 结果
     */

    @Override
    public int insertMonitorSys(MonitorSys monitorSys)
    {
        return monitorSysMapper.insert(monitorSys);
    }

    /**
     * 修改服务器管理
     *
     * @param monitorSys 服务器管理
     * @return 结果
     */
    @Override
    public int updateMonitorSys(MonitorSys monitorSys)
    {
        return monitorSysMapper.updateById(monitorSys);
    }

    /**
     * 批量删除服务器管理
     *
     * @param ids 需要删除的服务器管理主键
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteMonitorSysByIds(Long[] ids)
    {
        monitorSysInfoMapper.deleteByIpid(ids);
        return monitorSysMapper.deleteMonitorSysByIds(ids);
    }

    /**
     * 删除服务器管理信息
     *
     * @param id 服务器管理主键
     * @return 结果
     */
    @Override
    public int deleteMonitorSysById(Long id)
    {
        return monitorSysMapper.deleteById(id);
    }

    /**
     * 测试连接结果
     *@param monitorSys 机器管理
     * @return 结果
     */
    @Override
    public AjaxResult testLink(MonitorSys monitorSys) {
        boolean connect = LinuxStateForShell.connect(monitorSys.getUserName(),monitorSys.getUserPassword(),
                monitorSys.getIp(),monitorSys.getIpPort());
        if (connect){
            return AjaxResult.success("连接成功!","success");
        }
        return AjaxResult.success("连接失败!","error");
    }
}
