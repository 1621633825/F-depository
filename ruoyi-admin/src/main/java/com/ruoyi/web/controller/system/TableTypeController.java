package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.web.domain.TableType;
import com.ruoyi.web.service.ITableTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 桌位Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/table/type")
public class TableTypeController extends BaseController
{
    private final String prefix = "system/tableType";

    @Autowired
    private ITableTypeService tableTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/tableType";
    }

    /**
     * 查询桌位列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TableType tableType)
    {
        startPage();
        List<TableType> list = tableTypeService.selectTableTypeList(tableType);
        return getDataTable(list);
    }

    /**
     * 导出桌位列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "桌位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TableType tableType)
    {
        List<TableType> list = tableTypeService.selectTableTypeList(tableType);
        ExcelUtil<TableType> util = new ExcelUtil<TableType>(TableType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增桌位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存桌位
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "桌位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TableType tableType)
    {
        return toAjax(tableTypeService.insertTableType(tableType));
    }

    /**
     * 修改桌位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TableType tableType = tableTypeService.selectTableTypeById(id);
        mmap.put("tableType", tableType);
        return prefix + "/edit";
    }

    /**
     * 修改保存桌位
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "桌位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TableType tableType)
    {
        return toAjax(tableTypeService.updateTableType(tableType));
    }

    /**
     * 删除桌位
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "桌位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tableTypeService.deleteTableTypeByIds(ids));
    }
}
