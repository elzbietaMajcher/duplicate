package duplicate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DuplicatedListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    private ObjectFile obj1;
    private ObjectFile obj2;
    private ObjectFile obj3;
    private ObjectFile obj4;
    private ObjectFile obj5;
    private List<ObjectFile> fullList = new ArrayList<>();

    @Before
    public void createObjects() {
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
    }

    @Test
    public void duplicateListHas2ObjectsWithTheSameType() {
        List<ObjectFile> duplicatesList = DuplicatedList.createDuplicatedList(fullList, 0, "type");
        assertEquals(2, duplicatesList.size());
    }

    @Test
    public void duplicateListHas3ObjectsWithTheSameType() {
        ObjectFile obj6 = new ObjectFile("n6", "t3", "p6", 2111166, 6000);
        fullList.add(obj6);
        List<ObjectFile> testedList = fullList;
        List<ObjectFile> duplicatesList = DuplicatedList.createDuplicatedList(testedList, 2, "type");
        assertEquals(3, duplicatesList.size());
    }


    @Test
    public void listHas3ObjectFilesWithTheSameName() {

        List<ObjectFile> duplicatesList = DuplicatedList.createDuplicatedList(fullList, 0, "name");
        assertEquals(3, duplicatesList.size());
    }

    @Test
    public void listHas3ObjectFilesWithTheSameSize() {
        List<ObjectFile> duplicatesList = DuplicatedList.createDuplicatedList(fullList, 1, "sizeInBytes");
        assertEquals(3, duplicatesList.size());
    }

    private double precision = 1e-10;



}
