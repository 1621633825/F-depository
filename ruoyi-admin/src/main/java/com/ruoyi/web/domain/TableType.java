package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 桌位对象 table_type
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class TableType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 桌位编号 */
    @Excel(name = "桌位编号")
    private String tableId;

    /** 状态：1：就餐中，0：正常使用 */
    @Excel(name = "状态：1：就餐中，0：正常使用")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTableId(String tableId) 
    {
        this.tableId = tableId;
    }

    public String getTableId() 
    {
        return tableId;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tableId", getTableId())
            .append("state", getState())
            .toString();
    }
}
