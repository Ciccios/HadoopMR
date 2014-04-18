package com.hadoop.simplemr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class HadoopMR  {


    public static class MRMapper extends Mapper<IntWritable, Text, Text, IntWritable> {

        @Override
        protected void map(IntWritable key, Text value, Context context) throws IOException, InterruptedException {

            /**
             * Simply writing the input as is to the reducer
             */
            context.write(value, new IntWritable(1));
        }
    }

    public static class MRReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            int sum = 0;

            for (IntWritable ignored : values) {
                sum += 1;
            }

            context.write(key, new IntWritable(sum));
        }
    }
}
