package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * Created by qiudeyang on 30/11/16.
 */
public class TestMkdir {
    public static void main(String[] args) {
        String uri = "hdfs://192.168.80.32/user/qiudeyang/testmkdir";
        Configuration conf = new Configuration();
        try{
            FileSystem fs = FileSystem.get(URI.create(uri),conf);
            fs.mkdirs(new Path(uri));
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
