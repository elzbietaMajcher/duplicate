package duplicate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListWithDuplicatedListsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    ListWithDuplicatesLists listWithDuplicatesLists = new ListWithDuplicatesLists();

    DuplicatedListTest duplicatedListTest = new DuplicatedListTest();

    DataFactory dataFactory = new DataFactory();
    List<ObjectFile> fullList = dataFactory.createObjects2();


//    public List<ObjectFile> getSetupData() {
//        return DataFactory.createObjects2();
//    }


    @Test
    public void checkDataFactory(){
        for (ObjectFile o: fullList
             ) {
            System.out.println(o);

        }
    }

    @Test

    public void givenListSortedByNameHas2DuplicateList() {
        assertEquals(2, listWithDuplicatesLists.createListOfDuplicatedLists(fullList, "name"));
    }

    @Test
    public void givenListSortedByTypeHas3DuplicateList() {
        assertEquals(3, listWithDuplicatesLists.createListOfDuplicatedLists(fullList, "type"));
    }

    @Test
    public void givenListSortedBySizeHas2DuplicatedList() {
        assertEquals(2, listWithDuplicatesLists.createListOfDuplicatedLists(fullList, "sizeInBytes"));

    }

}
