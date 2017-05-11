package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//　同删除文件代码一样，只是换成删除目录路径即可，如果目录下有文件，要进行递归删除。
public class DeleteDirectory {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);
        Path deleDirectory = new Path("/user/qiudeyang/createdir");
        boolean isDeleted = hdfs.delete(deleDirectory, true);
        System.out.println("isDeleted " + isDeleted);
    }
}
