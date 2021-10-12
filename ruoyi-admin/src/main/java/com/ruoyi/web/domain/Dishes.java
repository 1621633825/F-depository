package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 菜品对象 dishe
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class Dishes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String dishesName;

    /** 菜品单价 */
    @Excel(name = "菜品单价")
    private BigDecimal dishesPrice;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Long reserveNum;

    /** 菜品参考图片 */
    @Excel(name = "菜品参考图片")
    private String imagePath;

    /** 类型（关联类型表） */
    @Excel(name = "类型", readConverterExp = "关=联类型表")
    private String dishesType;

    /** 状态：1 正常销售，0 停止销售 */
    @Excel(name = "状态：1 正常销售，0 停止销售")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDishesName(String dishesName) 
    {
        this.dishesName = dishesName;
    }

    public String getDishesName() 
    {
        return dishesName;
    }
    public void setDishesPrice(BigDecimal dishesPrice) 
    {
        this.dishesPrice = dishesPrice;
    }

    public BigDecimal getDishesPrice() 
    {
        return dishesPrice;
    }
    public void setReserveNum(Long reserveNum) 
    {
        this.reserveNum = reserveNum;
    }

    public Long getReserveNum() 
    {
        return reserveNum;
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }
    public void setDishesType(String type)
    {
        this.dishesType = type;
    }

    public String getDishesType()
    {
        return dishesType;
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
            .append("dishesName", getDishesName())
            .append("dishesPrice", getDishesPrice())
            .append("reserveNum", getReserveNum())
            .append("imagePath", getImagePath())
            .append("type", getDishesType())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
