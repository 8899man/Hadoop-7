package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//通过"FileSystem.getModificationTime()"可查看指定HDFS文件的修改时间。
public class GetTime {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);

        Path path = new Path("/user/qiudeyang/name.txt");

        FileStatus fileStatus = hdfs.getFileStatus(path);
        long modTime = fileStatus.getModificationTime();
        System.out.println("文件修改时间" + modTime);

    }
}
