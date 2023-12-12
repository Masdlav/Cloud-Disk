package com.networkDisk.dao;

import com.networkDisk.entity.FileFolder;
import com.networkDisk.entity.MyFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileFolderMapper {
    Integer deleteFileFolderById(Integer fileFolderId); // 根据文件夹的id删除文件夹
    Integer deleteFileFolderByParentFolderId(Integer parentFolderId); // 根据父文件夹的id删除文件夹
    Integer deleteFileFolderByFileStoreId(Integer fileStoreId); // 根据仓库的id删除文件夹
    Integer addFileFolder(FileFolder fileFolder); // 增加文件夹
    FileFolder getFileFolderById(Integer fileFolderId); // 根据文件夹的id获取文件夹
    List<FileFolder> getFileFolderByParentFolderId(Integer parentFolderId); // 根据父文件夹的id获取文件夹
    List<FileFolder> getFileFolderByFileStoreId(Integer fileStoreId); // 根据仓库的id获取文件夹
    Integer getFileFolderCountByFileStoreId(Integer fileStoreId); // 获得仓库的文件夹数量
    List<FileFolder> getRootFoldersByFileStoreId(Integer fileStoreId); // 根据仓库Id获得仓库根目录下的所有文件夹
    Integer updateFileFolderById(FileFolder fileFolder); // 根据文件夹的id修改文件夹信息
    List<MyFile> getFileByFileFolder(Integer fileStoreId); // 根据文件夹的id获取文件夹下面的文件
}
