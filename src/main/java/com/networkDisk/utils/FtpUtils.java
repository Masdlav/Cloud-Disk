package com.networkDisk.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;

@Slf4j
public class FtpUtils {
    // FTP客户端
    private static FTPClient ftpClient;
    // FTP服务器ip地址
    private static final String host = "192.168.67.128";
    // FTP服务器端口
    private static final int port = 21;
    // FTP登录账号
    private static final String username = "Everyone";
    // FTP登录密码
    private static final String password = "你需要修改此处";
    /**
     * FTP服务器基础目录
     */
    private static String BASEPATH = "";


    public static boolean initFTPClient() {
        try {
            //创建一个ftp客户端
            ftpClient = new FTPClient();
            //设置连接超时时间
            ftpClient.setConnectTimeout(10000);
            // 设置缓冲区
            ftpClient.setBufferSize(10240);
            // 连接FTP服务器
            ftpClient.connect(host, port);
            // 登陆FTP服务器
            ftpClient.login(username, password);
            // 设置传输类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // 设置传输模式
            ftpClient.enterLocalPassiveMode();

            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                log.info("FTP连接失败");
                ftpClient.disconnect();
                return false;
            } else {
                log.info("FTP连接成功");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            log.info("FTP的IP地址可能错误，请重新配置");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            log.info("FTP的端口错误,请重新配置");
            return false;
        }
        return true;
    }

    /**
     * 上传文件
     * @param ftpPath  ftp文件存放物理路径
     * @param fileName 文件路径
     * @param input 文件输入流，即从本地服务器读取文件的IO输入流
     */
    // TODO
    public static boolean uploadFile(String ftpPath, String fileName, InputStream input){
        try {
            if(!initFTPClient()){
                return false;
            }
            if(!ftpClient.changeWorkingDirectory(ftpPath)){

            }


            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            fileName=new String(fileName.getBytes("GBK"),"iso-8859-1");
            ftpClient.storeFile(fileName, input);
            input.close();
            ftpClient.logout();
            System.out.println("upload succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 下载文件
     * @param ftpPath  ftp文件存放物理路径
     * @param localPath 本地存储文件的路径
     * @param fileName 文件名称
     */
    public static void downloadFile(String ftpPath, String localPath, String fileName) {

        FTPClient ftpClient = null;

        try {
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            log.error("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            log.error("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件读取错误。");
            e.printStackTrace();
        }
    }


}