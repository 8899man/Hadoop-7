package org.dalvin.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by qiudeyang on 30/11/16.
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws Exception {
        String localSrc = "/home/qiudeyang/BuptLab/cdh/cm/cloudera-manager-installer.bin";
        String dst = "hdfs://192.168.80.32/user/qiudeyang/cloudera";
        InputStream in = new FileInputStream(localSrc);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dst),conf);
        OutputStream out = fs.create(new Path(dst), new Progressable() {
            @Override
            public void progress() {
                System.out.println("***");
            }
        });
        IOUtils.copyBytes(in,out,4096,true);
    }
}
