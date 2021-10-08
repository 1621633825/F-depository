package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 订单详情对象 order_detail
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class OrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 菜品ID */
    @Excel(name = "菜品ID")
    private Long disheId;

    /** 菜品价格 */
    @Excel(name = "菜品价格")
    private BigDecimal dishePrice;

    /** 菜品数量 */
    @Excel(name = "菜品数量")
    private Long disheNum;

    /** 菜品总价 */
    @Excel(name = "菜品总价")
    private BigDecimal disheTotal;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setDisheId(Long disheId) 
    {
        this.disheId = disheId;
    }

    public Long getDisheId() 
    {
        return disheId;
    }
    public void setDishePrice(BigDecimal dishePrice) 
    {
        this.dishePrice = dishePrice;
    }

    public BigDecimal getDishePrice() 
    {
        return dishePrice;
    }
    public void setDisheNum(Long disheNum) 
    {
        this.disheNum = disheNum;
    }

    public Long getDisheNum() 
    {
        return disheNum;
    }
    public void setDisheTotal(BigDecimal disheTotal) 
    {
        this.disheTotal = disheTotal;
    }

    public BigDecimal getDisheTotal() 
    {
        return disheTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("disheId", getDisheId())
            .append("dishePrice", getDishePrice())
            .append("disheNum", getDisheNum())
            .append("disheTotal", getDisheTotal())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
