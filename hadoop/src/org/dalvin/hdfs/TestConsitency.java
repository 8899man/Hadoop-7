package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 30/11/16.
 */
public class TestConsitency {
    public static void main(String[] args) throws Exception{
        String uri = "hdfs://192.168.80.32/user/qiudeyang/wordcount1.txt";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FSDataOutputStream out = fs.create(new Path(uri));
        out.write("content".getBytes("UTF-8"));
        out.flush();
//        out.close();
        out.sync();
        System.out.println(fs.getFileStatus(new Path(uri)).getLen());
    }
}
