package me.pastleo.trustPropogation;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TheMapper extends Mapper<LongWritable, Text, IntWritable, FromOrTo> {

	@Override
	protected void map(LongWritable offset, Text line, Context context)
			throws IOException, InterruptedException {
		String[] nodesKeys = line.toString().split("[\\s]+");
		Integer f = Integer.parseInt(nodesKeys[0]);
		Integer t = Integer.parseInt(nodesKeys[1]);
		context.write(new IntWritable(f), new FromOrTo(FromOrTo.TYPE_TO, t));
		context.write(new IntWritable(t), new FromOrTo(FromOrTo.TYPE_FROM, f));
	}
}
