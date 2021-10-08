package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.web.service.ISysDictDataService;
import com.ruoyi.web.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 * 
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictTypeService dictTypeService;

    @Autowired
    private ISysDictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        return dictTypeService.selectDictDataByType(dictType);
    }

    /**
     * 根据类型获取菜品类型数据
     * @param dictType
     * @return
     */
    public List<SysDictData> getDishesType(String dictType)
    {
        return dictTypeService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    /**
     * 查询菜品类型接口
     *
     * @return 参数键值
     */
    public List<SysDictData> getDishesType()
    {
        return dictTypeService.selectDishesType();
    }

}
