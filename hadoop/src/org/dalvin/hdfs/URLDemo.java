package org.dalvin.hdfs;

import java.io.IOException;
import java.net.URL;

/**
 * Created by qiudeyang on 29/11/16.
 */
public class URLDemo {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://www.w3cschool.cc/index.html?language=cn#j2se");
            System.out.println("URL is "+url.toString());
            System.out.println("protocol is "+url.getProtocol());
            System.out.println("authority is "+url.getAuthority());
            System.out.println("file name is "+url.getFile());
            System.out.println("host is "+url.getHost());
            System.out.println("path is "+url.getPath());
            System.out.println("port is "+url.getPort());
            System.out.println("default port is "+url.getDefaultPort());
            System.out.println("query is "+url.getQuery());
            System.out.println("ref is "+url.getRef());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}