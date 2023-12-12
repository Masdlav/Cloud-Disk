package com.networkDisk.dao;

import com.networkDisk.entity.FileStore;
import org.apache.ibatis.annotations.Mapper;

// 与文件夹相关的数据库操作
@Mapper
public interface FileStoreMapper {
    public Integer addFileStore(FileStore fileStore); // 添加文件仓库（用户注册时调用）
    public FileStore getFileStoreByUserId(Integer userId); // 根据用户id获得文件仓库
    public FileStore getFileStoreById(Integer fileStoreId); // 根据文件仓库id获得文件仓库
    public Integer addSize(Integer id, Integer size); // 修改仓库当前已使用的容量
    public Integer subSize(Integer id, Integer size); // 修改仓库当前已使用的容量
    public Integer updatePermission(Integer id,Integer permission,Integer size); // 更新仓库权限
    public Integer deleteById(Integer id); // 通过主键删除仓库
}
