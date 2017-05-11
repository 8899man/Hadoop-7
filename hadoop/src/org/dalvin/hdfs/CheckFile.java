package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//通过"FileSystem.exists（Path f）"可查看指定HDFS文件是否存在，其中f为文件的完整路径。
public class CheckFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);
        Path path = new Path("/user/qiudeyang/newer");
        boolean isExist = hdfs.exists(path);
        System.out.println("isExist " + isExist);
    }
}
