

import java.util.*;

public class DSAobjectjs {
    public static void main(String[] args) {
        Map<String, Integer> m1 = new HashMap<>();
        String[] s1 = {"six", "one", "two", "one", "two", "three", "four", "four", "four", "five"};

        for (String i : s1) {
            if (m1.containsKey(i)) {
                m1.put(i, m1.get(i) + 1);
            } else {
                m1.put(i, 1);
            }
        }

        for(Map.Entry<String,Integer> i:m1.entrySet()) System.out.print(i.getKey()+" " );
//        m1.keySet(); m1.values();
//      m1.containsKey("three");  m1.get("two");//how many times two has come;
//        System.out.println(m1);

    }
}
//map 1 can be equa
