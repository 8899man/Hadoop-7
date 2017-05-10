package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 10/05/17.
 */
//通过"FileSystem.create（Path f）"可在HDFS上创建文件，其中f为文件的完整路径。
public class CreateFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri), conf);
        byte[] buff = "hello hadoop world\n".getBytes();

        Path path = new Path("/user/qiudeyang/createfile");

        FSDataOutputStream outputStream = hdfs.create(path);
        outputStream.write(buff, 0, buff.length);

    }
}
