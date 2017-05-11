package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.net.URI;

/**
 * Created by qiudeyang on 11/05/17.
 */
//通过"DatanodeInfo.getHostName（）"可获取HDFS集群上的所有节点名称。
public class GetList {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        DistributedFileSystem hdfs = (DistributedFileSystem)fs;

        DatanodeInfo[] datanodeInfoStats = hdfs.getDataNodeStats();

        for (int i = 0; i < datanodeInfoStats.length; i++) {
            System.out.println(datanodeInfoStats[i].getHostName());
        }
    }
}
