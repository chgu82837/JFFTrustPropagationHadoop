package me.pastleo.trustPropogation;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class TheReducer extends Reducer<IntWritable, FromOrTo, IntWritable, IntWritable> {

	@Override
	protected void reduce(IntWritable key, Iterable<FromOrTo> values, Context context)
			throws IOException, InterruptedException {
		ArrayList<IntWritable> fa = new ArrayList<IntWritable>();
		ArrayList<IntWritable> ta = new ArrayList<IntWritable>();
		for (FromOrTo v : values) {
			if (v.isFrom()) fa.add(v.value());
			else if (v.isTo()) ta.add(v.value());
		}

		for (IntWritable f : fa) {
			for (IntWritable t : ta) {
				context.write(f, t);
			}
		}
	}
}
