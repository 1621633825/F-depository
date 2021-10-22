package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.web.domain.Dishes;
import com.ruoyi.web.domain.DishesType;
import com.ruoyi.web.service.IDishesService;
import com.ruoyi.web.service.IDishesTypeService;
import org.apache.commons.lang3.StringUtils;
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
import com.ruoyi.web.domain.Order;
import com.ruoyi.web.service.IOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController
{
    private final String prefix = "system/order";

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IDishesTypeService dishesTypeService;

    @Autowired
    private IDishesService dishesService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 返回点餐页面，带上菜品类型和菜品数据
     * @return
     */
    @GetMapping("/orderPage")
    public String orderPage(String id, ModelMap mmap)
    {
        // 查询所有菜品类型
        List<SysDictData> dishesTypeList = dishesTypeService.selectDishesTypeListMap();
        // 根据类型查询菜品
        Dishes dishes = new Dishes();
        if(StringUtils.isNotBlank(id)) {
            dishes.setDishesType(id);
        } else {
            dishes.setDishesType(dishesTypeList.get(0).getDictValue());
        }
        List<Dishes> dishesList = dishesService.selectDishesList(dishes);
        mmap.put("dishesTypeList", dishesTypeList);
        mmap.put("dishesList", dishesList);

        return prefix + "/orderPage";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Order order)
    {
        startPage();
        List<Order> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Order order)
    {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Order order = orderService.selectOrderById(id);
        mmap.put("dishesOrder", order);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Order order)
    {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderService.deleteOrderByIds(ids));
    }
}
