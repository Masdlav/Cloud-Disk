package com.networkDisk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

// 文件仓库实体类
@AllArgsConstructor
@Data
@Builder
public class FileStore implements Serializable {
    // 文件仓库ID
    private Integer fileStoreId;
    // 用户ID
    private Integer userId;
    // 当前容量(单位MB)
    private Integer currentSize;
    //最大容量（单位MB）
    private Integer maxSize;
    //仓库权限：0可上传下载、1只允许下载、2禁止上传下载
    private Integer permission;
}
