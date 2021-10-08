package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.utils.SnowFlake;
import com.ruoyi.web.domain.Dishes;
import com.ruoyi.web.mapper.DishesMapper;
import com.ruoyi.web.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class DishesServiceImpl implements IDishesService
{
    @Autowired
    private DishesMapper dishesMapper;

    /**
     * 查询菜品
     * 
     * @param id 菜品ID
     * @return 菜品
     */
    @Override
    public Dishes selectDishesById(Long id)
    {
        return dishesMapper.selectDishesById(id);
    }

    /**
     * 查询菜品列表
     * 
     * @param dishes 菜品
     * @return 菜品
     */
    @Override
    public List<Dishes> selectDishesList(Dishes dishes)
    {
        return dishesMapper.selectDishesList(dishes);
    }

    /**
     * 新增菜品
     * 
     * @param dishes 菜品
     * @return 结果
     */
    @Override
    public int insertDishes(Dishes dishes)
    {
        dishes.setId(SnowFlake.nextId());
        dishes.setCreateTime(DateUtils.getNowDate());
        return dishesMapper.insertDishes(dishes);
    }

    /**
     * 修改菜品
     * 
     * @param dishes 菜品
     * @return 结果
     */
    @Override
    public int updateDishes(Dishes dishes)
    {
        dishes.setUpdateTime(DateUtils.getNowDate());
        return dishesMapper.updateDishes(dishes);
    }

    /**
     * 删除菜品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDishesByIds(String ids)
    {
        return dishesMapper.deleteDishesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除菜品信息
     * 
     * @param id 菜品ID
     * @return 结果
     */
    @Override
    public int deleteDishesById(Long id)
    {
        return dishesMapper.deleteDishesById(id);
    }
}
