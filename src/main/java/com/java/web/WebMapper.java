package com.java.web;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.java.sol.SoBean;

public class WebMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		SoBean sb = new SoBean(value);
		Text outputKey = new Text();
		IntWritable outputValue = new IntWritable(1);
		if(WebController.soCode == 0) {
			outputKey.set(sb.getName() + "," + sb.getSido() + "," + sb.getGungu() + "," + sb.getRealResidence());
			context.write(outputKey, outputValue);
		}else if(WebController.soCode == 1) {
			outputKey.set(sb.getName());
			context.write(outputKey, outputValue);
		}else if(WebController.soCode == 2) {
			outputKey.set(sb.getSido());
			context.write(outputKey, outputValue);
		}else if(WebController.soCode == 3) {
			outputKey.set(sb.getGungu());
			context.write(outputKey, outputValue);
		}else if(WebController.soCode == 4) {
			outputKey.set(sb.getName() + "," + sb.getRealResidence());
			context.write(outputKey, outputValue);
		}
	}
}
