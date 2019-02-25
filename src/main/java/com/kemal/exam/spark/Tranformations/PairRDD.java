package com.kemal.exam.spark.Tranformations;

import com.kemal.exam.spark.Tranformations.CupModel;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

public class PairRDD {
    public static void main(String[] args) {
        JavaSparkContext javaSparkContext=new JavaSparkContext("local","PairRDD");
        JavaRDD<String> javaRDD = javaSparkContext.textFile("/home/apricot/Downloads/WorldCup/WorldCups.csv");

        JavaRDD<CupModel> map = javaRDD.map(new Function<String, CupModel>() {
            public CupModel call(String s) throws Exception {
                String[] split = s.split(",");

                return new CupModel(split[0], split[1], split[2],
                        split[3], split[4], split[5], Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), split[9]);
            }
        });
        final JavaPairRDD<String, Integer> pairRDD = map.mapToPair(new PairFunction<CupModel, String, Integer>() {
            public Tuple2<String, Integer> call(CupModel cupModel) throws Exception {
                return Tuple2.apply(cupModel.totalAudience, cupModel.totalGoal);
            }
        });
        pairRDD.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> tuple2) throws Exception {
                System.out.println(tuple2._1+"--"+tuple2._2);
            }
        });


    }
}
