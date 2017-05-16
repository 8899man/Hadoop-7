package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
public class FileLoc {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);

        Path path = new Path("/user/qiudeyang/CachePerformanceTest/block-locations.sh");

        FileStatus fileStatus = hdfs.getFileStatus(path);
        System.out.println(hdfs.getDefaultBlockSize());
        System.out.println(hdfs.getDefaultReplication());
        BlockLocation[] blockLocations = hdfs.getFileBlockLocations(fileStatus,0,fileStatus.getLen());
        for (int i = 0; i < blockLocations.length; i++) {
            System.out.println(blockLocations[i]);
        }


    }
}
