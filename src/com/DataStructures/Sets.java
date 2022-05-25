package com.DataStructures;

import java.util.HashSet;
import java.util.Set;

public class Sets {
    public char findFirstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
