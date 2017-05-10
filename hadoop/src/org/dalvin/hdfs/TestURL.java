package org.dalvin.hdfs;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by qiudeyang on 29/11/16.
 */
public class TestURL {
    public static void test4() throws IOException {
        URL url = new URL("http://lavasoft.blog.51cto.com/attachment/200811/200811271227767778082.jpg");
        Object obj = url.getContent();
        System.out.println(obj.getClass().getName());
    }

    public static void test3() throws IOException {
        URL url = new URL("http://www.runoob.com/java/java-url-processing.html");
        URLConnection urlConnection = url.openConnection();
        InputStream in = urlConnection.getInputStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print(c);
        }
        in.close();
    }

    public static void test2() throws IOException {
        URL url = new URL("http://www.hrtsea.com/down/soft/45.htm");
        Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.println((char) c);
        }
        reader.close();
    }

    public static void test1() throws IOException {
        URL url = new URL("http://lavasoft.blog.51cto.com/62575/120430");
        InputStream in = url.openStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.println(c);
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        test4();
        test3();
        test2();
        test1();
    }
}
