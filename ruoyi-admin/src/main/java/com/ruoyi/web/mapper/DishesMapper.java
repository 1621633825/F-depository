package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Dishes;

import java.util.List;

/**
 * 菜品Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface DishesMapper
{
    /**
     * 查询菜品
     * 
     * @param id 菜品ID
     * @return 菜品
     */
    public Dishes selectDishesById(Long id);

    /**
     * 查询菜品列表
     * 
     * @param dishes 菜品
     * @return 菜品集合
     */
    public List<Dishes> selectDishesList(Dishes dishes);

    /**
     * 新增菜品
     * 
     * @param dishes 菜品
     * @return 结果
     */
    public int insertDishes(Dishes dishes);

    /**
     * 修改菜品
     * 
     * @param dishes 菜品
     * @return 结果
     */
    public int updateDishes(Dishes dishes);

    /**
     * 删除菜品
     * 
     * @param id 菜品ID
     * @return 结果
     */
    public int deleteDishesById(Long id);

    /**
     * 批量删除菜品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDishesByIds(String[] ids);
}
