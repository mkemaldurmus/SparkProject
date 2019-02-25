package com.kemal.exam.spark.Tranformations;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;
import java.util.Iterator;

public class Flatmap {
    public static void main(String[] args) {
        final JavaSparkContext context=new JavaSparkContext("local", "Spark");
        JavaRDD<String> rawData = context.textFile("/home/apricot/Downloads/WorldCup/WorldCups.csv");
        System.out.println(rawData.count());
        JavaRDD<String> distinct = rawData.distinct();
        System.out.println(distinct.count());
        JavaRDD<String> sample = rawData.sample(true, 0.5);
        sample.foreach(new VoidFunction<String>() {
            public void call(String s) throws Exception {
                System.out.println(s);

            }
        });
        JavaRDD<String> flatMap = rawData.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(",")).iterator();
            }
        });
        flatMap.foreach(new VoidFunction<String>() {
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });
        JavaRDD<String> union = rawData.union(sample);
        System.out.println("union "+union.count());
        System.out.println(rawData.count());
        System.out.println(sample.count());
    }
}
