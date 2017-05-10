package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 30/11/16.
 */
public class ListStatus {
    public static void main(String[] args) throws Exception{
        String uri = "hdfs://datanode32/user/qiudeyang/spark";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FileStatus[] status = fs.listStatus(new Path(uri));
        for (int i = 0; i < status.length; i++) {
            System.out.println(status[i]);
        }
    }
}
