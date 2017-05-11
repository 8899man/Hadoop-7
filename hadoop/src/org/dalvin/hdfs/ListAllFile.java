package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//通过"FileStatus.getPath（）"可查看指定HDFS中某个目录下所有文件。
public class ListAllFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);

        Path path = new Path("/user/qiudeyang/CachePerformanceTest");

        FileStatus[] fileStatus = hdfs.listStatus(path);
        for (int i = 0; i < fileStatus.length; i++) {
            System.out.println(fileStatus[i].getPath());
        }
    }
}
