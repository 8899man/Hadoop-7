package org.dalvin.hdfs;

/**
 * Created by qiudeyang on 05/10/16.
 */
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {

     public static class TokenizerMapper extends
            Mapper<Object, Text, Text, Text> {

        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            String line = value.toString();
            String[] array = line.split("\t");
            if (array.length == 7) {
                String userID = array[1];
                String spName = array[4];
                String uploadTraffic = array[5];
                String downloadTraffic = array[6];
                context.write(new Text(userID + "\t" + spName), new Text(
                        uploadTraffic + "\t" + downloadTraffic));

            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0, uploadTrafficSum = 0, downloadTrafficSum = 0;
            for (Text val : values) {
                String[] array1 = val.toString().split("\t");
                sum++;
                uploadTrafficSum += Integer.parseInt(array1[0]);
                downloadTrafficSum += Integer.parseInt(array1[1]);

            }
            context.write(key, new Text(sum + "\t" + uploadTrafficSum + "\t"
                    + downloadTrafficSum));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args)
                .getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: wordcount <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = new Job(conf, "lessonwordcount");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job, new Path(
                otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
