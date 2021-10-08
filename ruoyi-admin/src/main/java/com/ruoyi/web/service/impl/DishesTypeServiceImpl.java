package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.utils.SnowFlake;
import com.ruoyi.web.domain.DishesType;
import com.ruoyi.web.mapper.DishesTypeMapper;
import com.ruoyi.web.service.IDishesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 菜品类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class DishesTypeServiceImpl implements IDishesTypeService
{
    @Autowired
    private DishesTypeMapper dishesTypeMapper;

    /**
     * 查询菜品类型
     * 
     * @param id 菜品类型ID
     * @return 菜品类型
     */
    @Override
    public DishesType selectDishesTypeById(Long id)
    {
        return dishesTypeMapper.selectDishesTypeById(id);
    }

    /**
     * 查询菜品类型列表
     * 
     * @param dishesType 菜品类型
     * @return 菜品类型
     */
    @Override
    public List<DishesType> selectDishesTypeList(DishesType dishesType)
    {
        return dishesTypeMapper.selectDishesTypeList(dishesType);
    }

    /**
     * 新增菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    @Override
    public int insertDishesType(DishesType dishesType)
    {
        dishesType.setCreateTime(new Date());
        dishesType.setId(SnowFlake.nextId());
        return dishesTypeMapper.insertDishesType(dishesType);
    }

    /**
     * 修改菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    @Override
    public int updateDishesType(DishesType dishesType)
    {
        return dishesTypeMapper.updateDishesType(dishesType);
    }

    /**
     * 删除菜品类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDishesTypeByIds(String ids)
    {
        return dishesTypeMapper.deleteDishesTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除菜品类型信息
     * 
     * @param id 菜品类型ID
     * @return 结果
     */
    @Override
    public int deleteDishesTypeById(Long id)
    {
        return dishesTypeMapper.deleteDishesTypeById(id);
    }

    @Override
    public List<SysDictData> selectDishesTypeListMap() {
        return dishesTypeMapper.selectDishesTypeListMap();
    }


}
