package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 10/05/17.
 */
//通过"FileSystem.copyFromLocalFile（Path src，Patch dst）"可将本地文件上传到HDFS的指定位置上
// 其中src和dst均为文件的完整路径。
public class CopyFile {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri),conf);
        Path src = new Path("/home/qiudeyang/graduate/linshurong/CachePerformanceTest");
        Path dst = new Path("/user/qiudeyang/");

        hdfs.copyFromLocalFile(src, dst);

        FileStatus[] files = hdfs.listStatus(dst);
        for (FileStatus file : files) {
            System.out.println(file.getPath());
        }
    }
}
