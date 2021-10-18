package Test;

import com.sun.source.tree.Tree;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @ClassName MyTest
 * @Author dy
 * @Date 2021/8/4 15:22
 * @Version 1.0
 **/

public class MyTest {
    @Test
    public void test() {
        int[] arr = {-2,-1,5,8,10};
        int sum = Arrays.stream(arr).sum();
        System.out.println(Arrays.binarySearch(arr, 0));
        System.out.println(sum);
    }
}


