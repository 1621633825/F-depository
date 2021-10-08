package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 订单对象 order
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 桌位编号 */
    @Excel(name = "桌位编号")
    private String tableNumber;

    /** 人数 */
    @Excel(name = "人数")
    private Long peopleNum;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal totalAmount;

    /** 状态：0未制作，1制作中 */
    @Excel(name = "状态：0未制作，1制作中")
    private Integer state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTableNumber(String tableNumber) 
    {
        this.tableNumber = tableNumber;
    }

    public String getTableNumber() 
    {
        return tableNumber;
    }
    public void setPeopleNum(Long peopleNum) 
    {
        this.peopleNum = peopleNum;
    }

    public Long getPeopleNum() 
    {
        return peopleNum;
    }
    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tableNumber", getTableNumber())
            .append("peopleNum", getPeopleNum())
            .append("totalAmount", getTotalAmount())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
