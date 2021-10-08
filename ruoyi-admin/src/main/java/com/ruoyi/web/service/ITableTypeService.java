package com.ruoyi.web.service;

import com.ruoyi.web.domain.TableType;

import java.util.List;

/**
 * 桌位Service接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface ITableTypeService 
{
    /**
     * 查询桌位
     * 
     * @param id 桌位ID
     * @return 桌位
     */
    public TableType selectTableTypeById(Long id);

    /**
     * 查询桌位列表
     * 
     * @param tableType 桌位
     * @return 桌位集合
     */
    public List<TableType> selectTableTypeList(TableType tableType);

    /**
     * 新增桌位
     * 
     * @param tableType 桌位
     * @return 结果
     */
    public int insertTableType(TableType tableType);

    /**
     * 修改桌位
     * 
     * @param tableType 桌位
     * @return 结果
     */
    public int updateTableType(TableType tableType);

    /**
     * 批量删除桌位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTableTypeByIds(String ids);

    /**
     * 删除桌位信息
     * 
     * @param id 桌位ID
     * @return 结果
     */
    public int deleteTableTypeById(Long id);
}
