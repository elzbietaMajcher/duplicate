package com.em.dups.internal;

import java.util.ArrayList;
import java.util.List;

/**
 *  support class to create data to test
 */
 public class DataFactory {


    public static List<AFile> createObjects1() {
        List<AFile> allFile = new ArrayList<>();
        /* TODO:  it should be done using clone  to get multiple obj with less code
        https://stackoverflow.com/questions/869033/how-do-i-copy-an-object-in-java
      */

        AFile obj1 = new AFile("n", "t", "p1", 1, 1);
        AFile obj2 = new AFile("n2", "t2", "p2", 2, 4);
        AFile obj3 = new AFile("n3", "t3", "p3", 3, 4);
        AFile obj4 = new AFile("n", "t3", "p4", 4, 4);
        AFile obj5 = new AFile("n", "t", "p5", 5, 5);

        allFile.add(obj1);
        allFile.add(obj2);
        allFile.add(obj3);
        allFile.add(obj4);
        allFile.add(obj5);

        return allFile;
    }

    public static List<AFile> createObjects2() {
        List<AFile> allFile = createObjects1();
        AFile obj6 = new AFile("n6", "t3", "p6", 2111166, 6000);
        AFile obj7 = new AFile("n6", "t4", "p7", 1, 1);
        AFile obj8 = new AFile("n5", "t2", "p8", 8, 8);
        AFile obj9 = new AFile("n4", "t3", "p9", 9, 9);

        allFile.add(obj6);
        allFile.add(obj7);
        allFile.add(obj8);
        allFile.add(obj9);

        return allFile;
    }

}
