package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 10/05/17.
 */
//通过"FileSystem.mkdirs（Path f）"可在HDFS上创建文件夹，其中f为文件夹的完整路径。
public class CreateDir {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);

        Path path = new Path("/user/qiudeyang/createdir");
        hdfs.mkdirs(path);
        System.out.println("done");
    }
}
