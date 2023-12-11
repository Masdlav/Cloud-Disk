package com.networkDisk.dao;

import com.networkDisk.entity.FileFolder;
import com.networkDisk.entity.MyFile;
import com.networkDisk.entity.TempFile;

import java.util.List;

// (TempFile)表数据库访问层
public interface TempFileMapper {
    int insert(TempFile tempFile); // 添加TempFile
    int deleteById(Integer fileId); // 删除TempFile
    TempFile queryById(Integer fileId); // 查询单条数据
    List<TempFile> queryAll(); // 查询全部数据
    List<TempFile> queryAll(TempFile tempFile); // 实体作为筛选条件查询数据
    int update(TempFile tempFile); // 修改TempFile
}
