package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.DishesType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.service.IDishesTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 菜品类型Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/dishes/type")
public class DishesTypeController extends BaseController
{
    private final String prefix = "system/dishesType";

    @Autowired
    private IDishesTypeService dishesTypeService;

    @GetMapping()
    public String type()
    {
        return prefix + "/dishesType";
    }

    /**
     * 查询菜品类型列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DishesType dishesType)
    {
        startPage();
        List<DishesType> list = dishesTypeService.selectDishesTypeList(dishesType);
        return getDataTable(list);
    }

    /**
     * 导出菜品类型列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "菜品类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DishesType dishesType)
    {
        List<DishesType> list = dishesTypeService.selectDishesTypeList(dishesType);
        ExcelUtil<DishesType> util = new ExcelUtil<DishesType>(DishesType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增菜品类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存菜品类型
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "菜品类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DishesType dishesType)
    {
        return toAjax(dishesTypeService.insertDishesType(dishesType));
    }

    /**
     * 修改菜品类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DishesType dishesType = dishesTypeService.selectDishesTypeById(id);
        mmap.put("dishesType", dishesType);
        return prefix + "/edit";
    }

    /**
     * 修改保存菜品类型
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "菜品类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DishesType dishesType)
    {
        return toAjax(dishesTypeService.updateDishesType(dishesType));
    }

    /**
     * 删除菜品类型
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "菜品类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dishesTypeService.deleteDishesTypeByIds(ids));
    }

    /**
     * 查询菜品类型列表不分页
     */
    @GetMapping("/listMap")
    @ResponseBody
    public AjaxResult listMap()
    {
        return AjaxResult.success(dishesTypeService.selectDishesTypeListMap());
    }
}
