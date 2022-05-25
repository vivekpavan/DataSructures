package com.DataStructures;

import java.util.*;
import java.util.Map;

public class StringManipulation {
    public static int findVowels(String input){
        if(input == null)
            return 0;
        int count = 0;
//        List<Character> list = new ArrayList<>();
//        list.add('a');
//        list.add('e');
//        list.add('i');
//        list.add('o');
//        list.add('u');
        String vowels = "aeiou";
        for(char ch : input.toLowerCase().toCharArray())
            if(vowels.indexOf(ch) != -1)
                count++;
        return count;
    }

    public static String reverseString(String input){
        if(input == null)
            return "";
        StringBuilder reversed = new StringBuilder();
        for(int i = input.length() -1;i >= 0;i--)
            reversed.append(input.charAt(i));
        return reversed.toString();
    }
    public static String reverseWords(String input){
        if(input == null)
            return "";
        String[] words = input.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
//        StringBuilder reverser = new StringBuilder();
//        String[] str = input.split(" ");
//        for(int i = str.length -1;i >= 0;i--)
//            reverser.append(str[i]).append(" ");
//        return reverser.toString().trim();
    }
    public static boolean isStringRotated(String input1,String input2){
        if(input1 == null || input2 == null)
            return false;
        return (input1.length() == input2.length()) &&
                ((input1 + input1).contains(input2));
    }
    //comparison approach
    public static boolean isStringRotate(String input1,String input2){
        if(input1.length() != input2.length())
            return false;
        int n = 0;
        int m = getDifference(input1,input2);
        int while_count = 0;
        while(while_count < input1.length() && input1.charAt(n++) == input2.charAt(m++)){
            if(m == input1.length())
                m=0;
            while_count++;
            if(while_count == input1.length())
                return true;
        }
        return false;
    }
    private static int getDifference(String input1,String input2){
        int count = -1;
        int n = 0;
        for(char ch : input2.toCharArray()){
            count++;
            if(input1.charAt(n) == ch)
                break;
        }
        return count;
    }
    public static String removeDuplicate(String input){
        if(input == null)
            return "";
        Set<Character> set = new HashSet<>();
        StringBuilder str =  new StringBuilder();
        for(char ch : input.toCharArray())
            if(!set.contains(ch)){
                set.add(ch);
                str.append(ch);
            }
        return str.toString();
    }
    //Using hashmap:
    public static char mostRepeated(String input){
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException();
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : input.trim().toCharArray()){
            map.putIfAbsent(ch,1);
            if(map.containsKey(ch))
                map.replace(ch,map.get(ch) + 1);
        }
        int max = Integer.MIN_VALUE;
        char max_char = ' ';
        for(char key : map.keySet()) {
            if (key == ' ')
                continue;
            if (map.get(key) > max) {
                max = map.get(key);
                max_char = key;
            }
        }
        return max_char;
    }
    //Using int[ASCII_SIZE]:
    public static char mostRepeat(String input){
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException();
        int Ascii_Size = 256;
        int[] array = new int[Ascii_Size];
        for(char ch : input.toCharArray())
            array[ch]++;
        int max = 0;
        char result = ' ';
        for(int i = 0;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
                result = (char)i;
            }
        }
        return result;
    }
    //improvisation of previous for loop
    public static char mostrepeat(String input){
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException();
        int Ascii_size = 256;
        int[] array = new int[Ascii_size];
        for(char ch : input.toCharArray())
            array[ch]++;
        int max = 0;
        char result = ' ';
        for(char ch : input.toCharArray()) {
            if (array[ch] > max) {
                max = array[ch];
                result = ch;
            }
        }
        return result;
    }
    public static String Capitalise(String input){
        if(input == null || input.trim().isEmpty())
            return "";
        String[] array = input
                .trim()
                .replaceAll(" +"," ")
                .split(" ");
        for(int i = 0;i < array.length;i++)
            array[i] = array[i].substring(0,1).toUpperCase() + array[i].substring(1).toLowerCase();

        return String.join(" ",array);
    }
    //Using Sorting
    public static boolean isAnagram(String input1,String input2){
        if(input1 == null || input2 == null)
            return false;
        char[] array1 = input1.toLowerCase().toCharArray();
        char[] array2 = input2.toLowerCase().toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);
    }
    //Using Histogram
    public static boolean areAnagram(String input1,String input2){
        if(input1 == null || input2 == null)
            return false;
        final int ENGLISH_ALPHABETS = 26;
        int[] frequencies = new int[ENGLISH_ALPHABETS];

        for(char ch : input1.toLowerCase().toCharArray())
            frequencies[ch - 'a']++;

        for(char ch : input2.toLowerCase().toCharArray()){
            if(frequencies[ch - 'a'] == 0)
                return false;
            frequencies[ch - 'a']--;
        }
        return true;
    }
    public static boolean isPalindrome(String input){
        //in the below implementation we are traversing our string four times:
//        StringBuilder builder = new StringBuilder(input);
//        builder.reverse();
//        return builder.toString().equals(input);
        //in the below implementation we traverse our string just half a time:
        if(input == null)
            return false;
        int left = 0;
        int right = input.length() - 1;
        while(left < right){
            if(input.charAt(left++) != input.charAt(right--))
                return false;
        }
        return true;
    }
}
