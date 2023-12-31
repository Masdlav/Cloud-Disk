package com.networkDisk.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
// 文件仓库数据统计类
public class FileStoreStatistics implements Serializable {
    // 文件仓库
    private FileStore fileStore;
    // 文档数
    private int doc;
    // 音乐数
    private int music;
    // 视频数
    private int video;
    // 图像数
    private int image;
    // 其他
    private int other;
    // 文件数
    private int fileCount;
    // 文件夹数
    private int folderCount;
}
