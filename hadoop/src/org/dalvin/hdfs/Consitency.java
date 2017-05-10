package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 30/11/16.
 */
public class Consitency {
    public static void main(String[] args) throws Exception{
        String uri = "hdfs://192.168.80.32/user/qiudeyang/wordcount1.txt";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        fs.create(new Path(uri));
        System.out.println(fs.exists(new Path(uri)));
    }
}
