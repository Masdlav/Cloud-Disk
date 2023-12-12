package com.networkDisk.service.impl;

import com.networkDisk.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class BaseService {

    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected MyFileMapper myFileMapper;
    @Autowired
    protected FileFolderMapper fileFolderMapper;
    @Autowired
    protected FileStoreMapper fileStoreMapper;
    @Autowired
    protected TempFileMapper tempFileMapper;
}
