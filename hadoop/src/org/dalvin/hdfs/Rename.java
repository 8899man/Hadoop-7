package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by qiudeyang on 10/05/17.
 */
//通过"FileSystem.rename（Path src，Path dst）"可为指定的HDFS文件重命名，其中src和dst均为文件的完整路径。
public class Rename {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        String uri = "hdfs://192.168.80.32/";
        FileSystem hdfs = FileSystem.get(URI.create(uri),conf);

        Path older = new Path("/user/qiudeyang/old");
        Path newer = new Path("/user/qiudeyang/newer");

        boolean isRename = hdfs.rename(older,newer);

        String result = isRename?"成功":"失败";

        System.out.println("文件重命名结果为:"+result);
    }
}
