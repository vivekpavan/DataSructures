package com.DataStructures;

import java.util.*;


public class BucketSort {
    public void sort(int[] array,int number_of_buckets){
        number_of_buckets = 3;
        List<List<Integer>> buckets = new ArrayList<>();

        //initializing the buckets list
        for(int i = 0;i < number_of_buckets;i++)
            buckets.add(new ArrayList<>());


        //adding elements to the appropriate bucket
        for(int i = 0;i < array.length;i++){
            var index = array[i] / number_of_buckets;
            buckets.get(index).add(array[i]);
        }

        //sorting each bucket list using inbuilt jumpsort in java
        //adding the bucket to the input array

        int j = 0;
        for(int i = 0; i < number_of_buckets;i++) {
            Collections.sort(buckets.get(i));
            for(int item : buckets.get(i))
                array[j++] = item;
        }
    }
}
