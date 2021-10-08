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
import com.ruoyi.web.domain.OrderDetail;
import com.ruoyi.web.service.IOrderDetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单详情Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/order/detail")
public class OrderDetailController extends BaseController
{
    private final String prefix = "system/orderDetail";

    @Autowired
    private IOrderDetailService orderDetailService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/orderDetail";
    }

    /**
     * 查询订单详情列表
     */
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderDetail orderDetail)
    {
        startPage();
        List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
        return getDataTable(list);
    }

    /**
     * 导出订单详情列表
     */
    @RequiresPermissions("system:detail:export")
    @Log(title = "订单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderDetail orderDetail)
    {
        List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
        ExcelUtil<OrderDetail> util = new ExcelUtil<OrderDetail>(OrderDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增订单详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单详情
     */
    @RequiresPermissions("system:detail:add")
    @Log(title = "订单详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.insertOrderDetail(orderDetail));
    }

    /**
     * 修改订单详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OrderDetail orderDetail = orderDetailService.selectOrderDetailById(id);
        mmap.put("orderDetail", orderDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单详情
     */
    @RequiresPermissions("system:detail:edit")
    @Log(title = "订单详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderDetail orderDetail)
    {
        return toAjax(orderDetailService.updateOrderDetail(orderDetail));
    }

    /**
     * 删除订单详情
     */
    @RequiresPermissions("system:detail:remove")
    @Log(title = "订单详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderDetailService.deleteOrderDetailByIds(ids));
    }
}
