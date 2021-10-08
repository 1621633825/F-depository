package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.OrderDetail;
import com.ruoyi.web.mapper.OrderDetailMapper;
import com.ruoyi.web.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class OrderDetailServiceImpl implements IOrderDetailService
{
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查询订单详情
     * 
     * @param id 订单详情ID
     * @return 订单详情
     */
    @Override
    public OrderDetail selectOrderDetailById(Long id)
    {
        return orderDetailMapper.selectOrderDetailById(id);
    }

    /**
     * 查询订单详情列表
     * 
     * @param orderDetail 订单详情
     * @return 订单详情
     */
    @Override
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail)
    {
        return orderDetailMapper.selectOrderDetailList(orderDetail);
    }

    /**
     * 新增订单详情
     * 
     * @param orderDetail 订单详情
     * @return 结果
     */
    @Override
    public int insertOrderDetail(OrderDetail orderDetail)
    {
        orderDetail.setCreateTime(DateUtils.getNowDate());
        return orderDetailMapper.insertOrderDetail(orderDetail);
    }

    /**
     * 修改订单详情
     * 
     * @param orderDetail 订单详情
     * @return 结果
     */
    @Override
    public int updateOrderDetail(OrderDetail orderDetail)
    {
        orderDetail.setUpdateTime(DateUtils.getNowDate());
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }

    /**
     * 删除订单详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailByIds(String ids)
    {
        return orderDetailMapper.deleteOrderDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单详情信息
     * 
     * @param id 订单详情ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailById(Long id)
    {
        return orderDetailMapper.deleteOrderDetailById(id);
    }
}
