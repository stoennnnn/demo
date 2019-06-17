package src.collection;


import java.util.Arrays;

/**
 * Created by  @ZQL  on 2019/6/3.
 * list源码学习
 */
public class List<I extends Number> {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,0,1,3,5,7,9};
        java.util.List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        for (Integer integer : list) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)==integer)
                    list.remove(i);
            }
        }
    }
}
