package duplicate;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    List<ObjectFile> fullList = new ArrayList<>();
    ObjectFile obj1;
    ObjectFile obj2;
    ObjectFile obj3;
    ObjectFile obj4;
    ObjectFile obj5;
    ObjectFile obj6;
    ObjectFile obj7;
    ObjectFile obj8;
    ObjectFile obj9;


    public List<ObjectFile> createObjects1() {

        obj1 = new ObjectFile("n", "t", "p1", 1, 1);
        obj2 = new ObjectFile("n2", "t2", "p2", 2, 4);
        obj3 = new ObjectFile("n3", "t3", "p3", 3, 4);
        obj4 = new ObjectFile("n", "t3", "p4", 4, 4);
        obj5 = new ObjectFile("n", "t", "p5", 5, 5);

        fullList.add(obj1);
        fullList.add(obj2);
        fullList.add(obj3);
        fullList.add(obj4);
        fullList.add(obj5);

        return fullList;
    }

    public List<ObjectFile> createObjects2() {
        DataFactory dataFactory = new DataFactory();

        fullList = dataFactory.createObjects1();
        obj6 = new ObjectFile("n6", "t3", "p6", 2111166, 6000);
        obj7 = new ObjectFile("n6", "t4", "p7", 1, 1);
        obj8 = new ObjectFile("n5", "t2", "p8", 8, 8);
        obj9 = new ObjectFile("n4", "t3", "p9", 9, 9);

        return fullList;
    }


}
