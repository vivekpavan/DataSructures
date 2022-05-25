package com.DataStructures;

import java.util.HashMap;

public class Map {

    public char findFirstNonRepeatedCharacter(String str){
        int count = 1;
        java.util.Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,count);
            }
            else{
                map.replace(ch,map.get(ch),map.get(ch) + 1);
            }
        }
        System.out.println(map);
        for(char ch : str.toCharArray()){
            if(map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }
}
