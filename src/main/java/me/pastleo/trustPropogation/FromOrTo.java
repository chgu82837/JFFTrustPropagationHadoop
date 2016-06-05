package me.pastleo.trustPropogation;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.IntWritable;

public class FromOrTo extends ArrayWritable {
    public static final int TYPE_FROM = 0;
    public static final int TYPE_TO = 1;

    public FromOrTo(){
        super(IntWritable.class);
    }
    public FromOrTo(int type, IntWritable value){
        super(IntWritable.class, new IntWritable[0]);
        IntWritable[] payload = {new IntWritable(type), value};
        this.set(payload);
    }
    public FromOrTo(int type, int value){
        this(type, new IntWritable(value));
    }
    private IntWritable get(int i){
        return (IntWritable) this.get()[i];
    }
    public boolean isFrom(){
        return this.get(0).get() == TYPE_FROM;
    }
    public boolean isTo(){
        return this.get(0).get() == TYPE_TO;
    }
    public IntWritable value(){
        return this.get(1);
    }
}
