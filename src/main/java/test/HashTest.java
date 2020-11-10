package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by victory_woo on 2020/10/26
 */
public class HashTest {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        table.put(1, 1);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,1);
    }
}
