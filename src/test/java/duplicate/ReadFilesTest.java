package duplicate;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReadFilesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    private String pathDirectoryManyFolders = "src\\test\\resources\\folder_testowy";
    private String pathDirectoryOneFile = "src\\test\\resources\\folder_testowy\\Nowy folder";


    DuplicatesMap scenarioOne = new DuplicatesMap();
    ObjectFile objectFile = new ObjectFile();
    DataFactory dataFactory = new DataFactory();
    List<ObjectFile> allList = dataFactory.createObjects1();
    List<ObjectFile> allList2 = dataFactory.createObjects2();


    @Test
    public void divideStringToTwoWordAndShowFirst() {
        String fullName = "name.type";
        String name = "name";
        assertEquals(name, ObjectFile.extractName(fullName));
    }

    @Test
    public void testDoMapScenarioEmptyArray() {
        List<ObjectFile> empty = new ArrayList<>();
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(empty, "name");
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneElement() {
        List<ObjectFile> one = new ArrayList<>();
        ObjectFile ob = new ObjectFile("n", "t", "p1", 1, 1);
        one.add(ob);
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(one, "name");
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneTheSameName() {
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList, "name");
        assertEquals(1, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameName() {
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList2, "name");
        assertEquals(2, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameExtension() {
        Map<String, List<ObjectFile>> maps = scenarioOne.doMap(allList2, "type");
        assertEquals(3, maps.size());
    }

    @Test
    public void testDoDuplicateListTheSameExtension() {
        ObjectFile objectFile = new ObjectFile("t", "t3");
        List<ObjectFile> result = scenarioOne.doDuplicateList(allList, objectFile, "type");
        assertEquals(2, result.size());
    }

    @Test
    public void divideStringToTwoWordAndShowSecond() {
        String fullName = "name.type";
        String type = "type";
        assertEquals(type, ObjectFile.extractType(fullName));
    }

    @Test
    public void divideStringInLastDotAndShowType() {
        String fullName = "name.restName.stillName.type";
        String type = "type";
        assertEquals(type, ObjectFile.extractType(fullName));
    }

    @Test
    public void divideStringToTwoWordsAndShowName() {
        String fullName = "name.restName.stillName.type";
        String name = "name.restName.stillName";
        assertEquals(name, ObjectFile.extractName(fullName));
    }

    @Test
    public void checkIfListHasOneObject() {
        File folder = new File(pathDirectoryOneFile);
        List<File> array = new ArrayList<File>();
        List<File> list = AllFileList.listFilesForFolder(folder, array);
        assertEquals(1, list.size());
    }

    @Test
    public void checkIfFileListHas17files() {
        File folder = new File(pathDirectoryManyFolders);
        ArrayList<File> array = new ArrayList<File>();
        List<File> list = AllFileList.listFilesForFolder(folder, array);
        assertEquals(17, list.size());
    }

    @Test
    public void checkIfObjectListHas17files() {
        long count = AllFileList.makeObjectFilesList(new File(pathDirectoryManyFolders)).size();
        assertEquals(17, count);
    }

}
