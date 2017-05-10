package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;


/**
 * Created by qiudeyang on 30/11/16.
 */
public class ShowFileStatusTest {
    public static void main(String[] args) throws Exception {
        String uri = "hdfs://192.168.80.32/user/qiudeyang/wordcount.txt";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FileStatus status = fs.getFileStatus(new Path(uri));
        System.out.println(status.getPath());
        System.out.println(status.isFile());
        System.out.println(status.getLen());
        System.out.println(status.getModificationTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(status.getReplication());
        System.out.println(status.getBlockSize());
        System.out.println(status.getAccessTime());
        System.out.println(status.getOwner());
        System.out.println(status.getGroup());
        System.out.println(status.getPermission().toString());

    }


}
