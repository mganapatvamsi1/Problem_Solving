package others.graphs;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void getList(List<String> list) {
        list = new ArrayList<String>();
        list.add("C");

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        System.out.println("test "+ list);
        getList(list);
        System.out.println("test "+ list);
    }


}
