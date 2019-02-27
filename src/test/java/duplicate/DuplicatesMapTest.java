package duplicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DuplicatesMapTest {

    DuplicatesMap scenarioOne = new DuplicatesMap();
    ObjectFile objectFile = new ObjectFile();
    DataFactory dataFactory = new DataFactory();

    //given
    List<ObjectFile> allList = dataFactory.createObjects1();
    List<ObjectFile> allList2 = dataFactory.createObjects2();


    @Test
    public void testDoMapScenarioEmptyArray() {
        //given
        List<ObjectFile> empty = new ArrayList<>();
        //when
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(empty, "name");
        //then
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneElement() {
        //given
        List<ObjectFile> one = new ArrayList<>();
        ObjectFile ob = new ObjectFile("n", "t", "p1", 1, 1);
        one.add(ob);
        //when
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(one, "name");
        //then
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneTheSameName() {
        //given: allList, String info = "name"
        //when
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList, "name");
        //then
        assertEquals(1, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameName() {
        //given: allList2
        String info = "name";
        //when
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList2, info);
        //then
        assertEquals(2, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameExtension() {
        //given: allList2
        String info = "type";
        //when
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList2, info);
        //then
        assertEquals(3, maps.size());
    }

    @Test
    public void testDoDuplicateListTheSameExtension() {
        //given: allList
        String info = "type";
        ObjectFile objectFile = new ObjectFile("t", "t3");
        //when
        List<ObjectFile> result = scenarioOne.doDuplicateList(allList, objectFile, info);
        //then
        assertEquals(2, result.size());
    }


}
