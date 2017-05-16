package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.io.IOUtils;

import java.net.URI;

/**
 * Created by qiudeyang on 16/05/17.
 */
public class ReadFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32";
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path path = new Path("/user/qiudeyang/name.txt");
        FSDataInputStream input = fs.open(path);
        IOUtils.copyBytes(input, System.out, 4096, false);
        System.out.println(fs.getBlockSize(path));
        System.out.println(fs.exists(path));
        System.out.println(fs.getDefaultBlockSize());
        System.out.println(fs.getDefaultReplication());
        System.out.println(fs.getFileBlockLocations(path,0,4096));
        System.out.println(fs.getFileChecksum(path));
        System.out.println(fs.getFileStatus(path));
        System.out.println(fs.isDirectory(path));
        System.out.println(fs.isFile(path));
        System.out.println(fs.getHomeDirectory());

    }
}
