package com.hadoop.simplemr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class HadoopMRTest {

    @Test
    public void testMapReduceJob() {

        HadoopMR.MRMapper mapper = new HadoopMR.MRMapper();
        HadoopMR.MRReducer reducer = new HadoopMR.MRReducer();

        MapReduceDriver<IntWritable, Text, Text, IntWritable, Text, IntWritable> mapr =
                MapReduceDriver.newMapReduceDriver(mapper, reducer);

        /**
         * Adding Input to the MapR
         */
        mapr.addInput(new IntWritable(1), new Text("Ciccio"));
        mapr.addInput(new IntWritable(1), new Text("Ciccio"));
        mapr.addInput(new IntWritable(1), new Text("Ciccio"));
        mapr.addInput(new IntWritable(1), new Text("Ciccio"));

        /**
         * Expected Output
         */
        mapr.withOutput(new Text("Ciccio"), new IntWritable(4));

        try {
            mapr.runTest();
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}