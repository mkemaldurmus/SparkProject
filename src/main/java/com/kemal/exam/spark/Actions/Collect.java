package com.kemal.exam.spark.Actions;

import com.kemal.exam.spark.Tranformations.CupModel;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.lang.reflect.Array;
import java.util.List;

public class Collect {
    public static void main(String[] args) {
        JavaSparkContext javaSparkContext=new JavaSparkContext("local","Collect");
        JavaRDD<String> rawData = javaSparkContext.textFile("/home/apricot/Downloads/WorldCup/WorldCups.csv");
        JavaRDD<CupModel> map = rawData.map(new Function<String, CupModel>() {

            public CupModel call(String s) throws Exception {
                String[] split = s.split(",");

                return new CupModel(split[0], split[1], split[2],
                        split[3], split[4], split[5], Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), split[9]);
            }
        });
        List<String> collect = rawData.collect();
        for (String x: collect){
            System.out.println(x);


        }
    }
}
