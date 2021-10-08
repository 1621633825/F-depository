package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.web.domain.DishesType;

import java.util.List;
import java.util.Map;

/**
 * 菜品类型Service接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface IDishesTypeService
{
    /**
     * 查询菜品类型
     * 
     * @param id 菜品类型ID
     * @return 菜品类型
     */
    public DishesType selectDishesTypeById(Long id);

    /**
     * 查询菜品类型列表
     * 
     * @param dishesType 菜品类型
     * @return 菜品类型集合
     */
    public List<DishesType> selectDishesTypeList(DishesType dishesType);

    /**
     * 新增菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    public int insertDishesType(DishesType dishesType);

    /**
     * 修改菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    public int updateDishesType(DishesType dishesType);

    /**
     * 批量删除菜品类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDishesTypeByIds(String ids);

    /**
     * 删除菜品类型信息
     * 
     * @param id 菜品类型ID
     * @return 结果
     */
    public int deleteDishesTypeById(Long id);

    List<SysDictData> selectDishesTypeListMap();
}
