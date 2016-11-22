package com.createHbase.app;

//mapreduce

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;


/**
 * @author Catherine
 *
 */
public class WordStat {
    
    /**
     * TableMapper<Text,IntWritable>  Text:output key type，IntWritable：output value type
     */
    public static class MyMapper extends TableMapper<Text,IntWritable>{
        
        private static IntWritable one = new IntWritable(1);
        private static Text word = new Text();
        
        @Override
        protected void map(ImmutableBytesWritable key, Result value,
                Context context)
                throws IOException, InterruptedException {

            //retrieve every row since only one column family
            String words = Bytes.toString(value.list().get(0).getValue());
            StringTokenizer st = new StringTokenizer(words); 
            while (st.hasMoreTokens()) {
                 String s = st.nextToken();
                 word.set(s);
                 context.write(word, one);
            }
        }
    }
    
    /**
     * TableReducer<Text,IntWritable>  Text:output key type，IntWritable：output value type，ImmutableBytesWritable：output type
     */
    public static class MyReducer extends TableReducer<Text,IntWritable,ImmutableBytesWritable>{
        
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values,
                Context context)
                throws IOException, InterruptedException {
            
            int sum = 0;
            for(IntWritable val:values) {
                sum+=val.get();
            }
            //add row record and each word will be the row key
            Put put = new Put(Bytes.toBytes(key.toString()));

            //result column family add num which will be frequency of the word
            //String.valueOf(sum) will transfer num to string，or the data will be \x00\x00\x00\x
            //transfer to bytes, and then save to hbase。
            put.add(Bytes.toBytes("result"), Bytes.toBytes("num"), Bytes.toBytes(String.valueOf(sum)));
            context.write(new ImmutableBytesWritable(Bytes.toBytes(key.toString())),put);
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        
        Configuration conf = HBaseConfiguration.create();
        Job job = new Job(conf,"wordstat");
        job.setJarByClass(Blog.class);
        
        
        Scan scan = new Scan();

        //take the column family
        scan.addColumn(Bytes.toBytes("content"),null);

        //mapper is word
        TableMapReduceUtil.initTableMapperJob("word", scan, MyMapper.class, Text.class, IntWritable.class, job);
　　　　 //Reducer will write stat
        TableMapReduceUtil.initTableReducerJob("stat", MyReducer.class, job);
        System.exit(job.waitForCompletion(true)?0:1);
    }
}