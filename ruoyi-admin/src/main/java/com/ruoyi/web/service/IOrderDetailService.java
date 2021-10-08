package com.ruoyi.web.service;

import com.ruoyi.web.domain.OrderDetail;

import java.util.List;

/**
 * 订单详情Service接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface IOrderDetailService 
{
    /**
     * 查询订单详情
     * 
     * @param id 订单详情ID
     * @return 订单详情
     */
    public OrderDetail selectOrderDetailById(Long id);

    /**
     * 查询订单详情列表
     * 
     * @param orderDetail 订单详情
     * @return 订单详情集合
     */
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail);

    /**
     * 新增订单详情
     * 
     * @param orderDetail 订单详情
     * @return 结果
     */
    public int insertOrderDetail(OrderDetail orderDetail);

    /**
     * 修改订单详情
     * 
     * @param orderDetail 订单详情
     * @return 结果
     */
    public int updateOrderDetail(OrderDetail orderDetail);

    /**
     * 批量删除订单详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderDetailByIds(String ids);

    /**
     * 删除订单详情信息
     * 
     * @param id 订单详情ID
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);
}
