package com.vivekchutke.microservice.promotion.pcfpromotionservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaValidationClass {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        list1.add(13);
        list1.add(3);

        System.out.println("Initial List is:"+list1);

        Set<Integer> set1 = new HashSet<Integer>(list1);

        System.out.println("Set is:"+set1);

        List<Integer> list2 = new ArrayList<Integer>(set1);

        System.out.println("Final List is:"+list2);


    }
}
