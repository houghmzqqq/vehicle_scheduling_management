package com.example.vehicle_scheduling_management.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:22 2018/4/22
 * @modified by:
 */
public class UrlTool {
    private URL url;
    private HttpURLConnection conn;
    private String _url;
    private String method = "GET";

    public UrlTool(){
//        this._url = "http://172.16.12.167:8080/teach/"+
//                "interface/course.json";
//        init();
    }

    public UrlTool(String _url) throws Exception {
        this._url = _url;
        init();
    }

    public UrlTool(String _url, String method) throws Exception {
        this._url = _url;
        this.method = method;
        init();
    }

    /**
     * 初始化，连接url
     * @throws Exception
     */
    public void init() throws Exception {
        openConnection(_url);
        doConnect();
    }

    /**
     * 打开连接
     * @param _url 网页url
     * @throws MalformedURLException
     */
    public void openConnection(String _url) throws MalformedURLException {
        this.url = new URL(_url);
    }

    /**
     * 进行连接，设置请求头
     *
     * @throws IOException
     */
    public void doConnect() throws IOException {
        //URLConnection
        conn = (HttpURLConnection)url.openConnection();

        conn.setRequestMethod(this.method);  //相当于: method=POST
        conn.setDoOutput(true);       //提交表单的参数 ---> true

//        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("Charset", "UTF-8");
//        conn.setRequestProperty("Content-Type",
//                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Accept-Encoding", "identity");
    }

    /**
     * 读取请求中的内容
     *
     * @throws IOException
     */
    public String getResponseMsg() throws IOException {
        String msg = "";
        int code = conn.getResponseCode();

        File file = new File(url.getFile());
        InputStream in = null;

//        //没有响应内容
//        if(conn.getContentLength() <= 0 ){
//            System.out.println(conn.getContentLength());
//            return "";
//        }

        byte[] buff = new byte[1024*100];
        if (code == HttpURLConnection.HTTP_OK) {
            in = conn.getInputStream();
            int num;
            int c = 0;
            while ((num = in.read()) != -1) {
                buff[c] = (byte) num;
                c++;
            }
            msg = new String(buff, 0, 1024*100);
        }
//        return msg.substring(1,msg.length());
        return msg;
    }

    public String get_url() {
        return _url;
    }
    public void set_url(String _url) throws Exception {
        this._url = _url;
        openConnection(_url);
        doConnect();
    }
}
