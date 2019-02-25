package com.kemal.exam.spark.Tranformations;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;


public class App {
    public static void main(String[] args) {
        final JavaSparkContext context=new JavaSparkContext("local", "SparkProject");
        JavaRDD<String> rawData = context.textFile("/home/apricot/Downloads/WorldCup/WorldCups.csv");
        JavaRDD<CupModel> newRaw = rawData.map(new Function<String, CupModel>() {
            public CupModel call(String line) throws Exception {
                String[] split = line.split(",");
                return new CupModel(split[0], split[1], split[2],
                        split[3], split[4], split[5], Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), split[9]);

            }

        });
        JavaRDD<CupModel> italyFilter = newRaw.filter(new Function<CupModel, Boolean>() {
            public Boolean call(CupModel cupModel) throws Exception {
                return cupModel.first.equals("Italy");
            }
        });
        newRaw.foreach(new VoidFunction<CupModel>() {
                           int counter=0;

                           public void call(CupModel cup) throws Exception {
                System.out.println(counter);

                if (cup.hometeam.equals(cup.first)){
                    counter++;

                }
                   }}

        );
        italyFilter.foreach(new VoidFunction<CupModel>() {
            public void call(CupModel cupModel1) throws Exception {
                System.out.println(cupModel1.year);
        }
    });
}
}
