package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//通过"FileSystem.delete（Path f，Boolean recursive）"可删除指定的HDFS文件，
// 其中f为需要删除文件的完整路径，recuresive用来确定是否进行递归删除。
public class DeleteFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);
        Path delefile = new Path("/user/qiudeyang/createfile");
        boolean isDeleted = hdfs.delete(delefile, false);
        System.out.println("Delete?" + isDeleted);
    }
}
