package src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda
{
    public static void main(String[] args){
        List<String> list= Arrays.asList("aa","bbb","cccc","ddddd","eeeeee");
        list.forEach(t-> System.out.println("元素是："+t));
    }
}
