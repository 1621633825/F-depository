package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.TableType;

import java.util.List;

/**
 * 桌位Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface TableTypeMapper 
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
     * 删除桌位
     * 
     * @param id 桌位ID
     * @return 结果
     */
    public int deleteTableTypeById(Long id);

    /**
     * 批量删除桌位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTableTypeByIds(String[] ids);
}
