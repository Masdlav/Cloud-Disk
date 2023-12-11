package com.networkDisk.dao;

import com.networkDisk.entity.FileStoreStatistics;
import com.networkDisk.entity.MyFile;

import java.util.List;

// 与文件相关的数据库操作
public interface MyFileMapper {
    Integer addFileByFileStoreId(MyFile myFile); // 添加文件
    Integer updateFileByFileId(MyFile myFile); // 根据文件id修改文件
    Integer deleteByFileId(Integer myFileId); // 根据文件的id删除文件
    Integer deleteByParentFolderId(Integer id); // 根据父文件夹的id删除文件
    MyFile getFileByFileId(Integer myFileId); // 根据文件的id获取文件
    List<MyFile> getRootFilesByFileStoreId(Integer fileStoreId); // 获得仓库根目录下的所有文件
    List<MyFile> getFilesByParentFolderId(Integer parentFolderId); // 根据父文件夹id获得文件
    List<MyFile> getFilesByType(Integer storeId, Integer type); // 根据类别获取文件
    FileStoreStatistics getCountStatistics(Integer id); // 获取仓库的统计信息
}
