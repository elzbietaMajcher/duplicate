package duplicate;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReadFilesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    private String pathDirectoryManyFolders = "src\\test\\resources\\folder_testowy";
    private String pathDirectoryOneFile = "src\\test\\resources\\folder_testowy\\Nowy folder";


    ObjectFile objectFile = new ObjectFile();
    DataFactory dataFactory = new DataFactory();
    List<ObjectFile> allList = dataFactory.createObjects1();


    @Test
    public void divideStringToTwoWordAndShowFirst() {
        String fullName = "name.type";
        String name = "name";
        assertEquals(name, ObjectFile.extractName(fullName));
    }

//    @Test
//    public void testAllVsScenarioOne() {
//
//        List<ObjectFile> result = new ArrayList<ObjectFile>();
//        for (ObjectFile o : allList) {
//            List<ObjectFile> resultO = o.getScenarioOne(allList);
//            System.out.println(o.getName());
//            System.out.println(resultO);
//
//            result.addAll(resultO);
//
//        }
//        assertEquals(3, result.size());
//    }

   @Test
   public void testAllScenarioOne(){
       Map<String, List<ObjectFile>> maps = objectFile.doMapScenarioOne(allList);
       assertEquals(1,maps.size());
   }


    @Test
    public void testSingleScenarioOne() {

        ObjectFile objectFile = new ObjectFile("n");
        List<ObjectFile> result = objectFile.getScenarioOne(allList, objectFile);
        //System.out.println(objectFile);
        System.out.println(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testScenarioTwo() {

        ObjectFile objectFile = new ObjectFile("t", "t3");
        List<ObjectFile> result = objectFile.getScenarioTwo(allList);
        System.out.println(objectFile);
        System.out.println(result);
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
