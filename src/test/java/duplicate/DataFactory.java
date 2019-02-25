package duplicate;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {


    public static List<ObjectFile> createObjects1() {
        List<ObjectFile> allFile = new ArrayList<>();
        ObjectFile obj1 = new ObjectFile("n", "t", "p1", 1, 1);
        ObjectFile obj2 = new ObjectFile("n2", "t2", "p2", 2, 4);
        ObjectFile obj3 = new ObjectFile("n3", "t3", "p3", 3, 4);
        ObjectFile obj4 = new ObjectFile("n", "t3", "p4", 4, 4);
        ObjectFile obj5 = new ObjectFile("n", "t", "p5", 5, 5);

        allFile.add(obj1);
        allFile.add(obj2);
        allFile.add(obj3);
        allFile.add(obj4);
        allFile.add(obj5);

        return allFile;
    }

    public static List<ObjectFile> createObjects2() {
        List<ObjectFile> allFile = createObjects1();
        ObjectFile obj6 = new ObjectFile("n6", "t3", "p6", 2111166, 6000);
        ObjectFile obj7 = new ObjectFile("n6", "t4", "p7", 1, 1);
        ObjectFile obj8 = new ObjectFile("n5", "t2", "p8", 8, 8);
        ObjectFile obj9 = new ObjectFile("n4", "t3", "p9", 9, 9);

        allFile.add(obj6);
        allFile.add(obj7);
        allFile.add(obj8);
        allFile.add(obj9);

        return allFile;
    }

}
