package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.utils.SnowFlake;
import com.ruoyi.web.domain.TableType;
import com.ruoyi.web.mapper.TableTypeMapper;
import com.ruoyi.web.service.ITableTypeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 桌位Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class TableTypeServiceImpl implements ITableTypeService
{
    private final TableTypeMapper tableTypeMapper;

    public TableTypeServiceImpl(TableTypeMapper tableTypeMapper) {
        this.tableTypeMapper = tableTypeMapper;
    }

    /**
     * 查询桌位
     * 
     * @param id 桌位ID
     * @return 桌位
     */
    @Override
    public TableType selectTableTypeById(Long id)
    {
        return tableTypeMapper.selectTableTypeById(id);
    }

    /**
     * 查询桌位列表
     * 
     * @param tableType 桌位
     * @return 桌位
     */
    @Override
    public List<TableType> selectTableTypeList(TableType tableType)
    {
        return tableTypeMapper.selectTableTypeList(tableType);
    }

    /**
     * 新增桌位
     * 
     * @param tableType 桌位
     * @return 结果
     */
    @Override
    public int insertTableType(TableType tableType)
    {
        tableType.setId(SnowFlake.nextId());
        tableType.setCreateTime(new Date());
        return tableTypeMapper.insertTableType(tableType);
    }

    /**
     * 修改桌位
     * 
     * @param tableType 桌位
     * @return 结果
     */
    @Override
    public int updateTableType(TableType tableType)
    {
        tableType.setUpdateTime(new Date());
        return tableTypeMapper.updateTableType(tableType);
    }

    /**
     * 删除桌位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTableTypeByIds(String ids)
    {
        return tableTypeMapper.deleteTableTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除桌位信息
     * 
     * @param id 桌位ID
     * @return 结果
     */
    @Override
    public int deleteTableTypeById(Long id)
    {
        return tableTypeMapper.deleteTableTypeById(id);
    }
}
