package com.witos.job.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.witos.common.core.annotation.Excel;
import com.witos.common.core.web.domain.TenantEntity;
import lombok.Data;

/**
 * 注册对象 xxl_job_registry
 *
 * @author witos
 * @date 2023-01-03
 */
@Data
@TableName("xxl_job_registry")
public class XxlJobRegistry extends TenantEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @TableId
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String registryGroup;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String registryKey;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String registryValue;



}
