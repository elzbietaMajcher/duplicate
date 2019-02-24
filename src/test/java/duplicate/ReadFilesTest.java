package duplicate;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadFilesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    private String pathDirectoryManyFolders = "src\\test\\resources\\folder_testowy";
    private String pathDirectoryOneFile = "src\\test\\resources\\folder_testowy\\Nowy folder";


    @Test
    public void divideStringToTwoWordAndShowFirst() {
        String fullName = "name.type";
        String name = "name";
        assertEquals(name, ObjectFile.extractName(fullName));
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
        long size = AllFileList.makeObjectFilesList(new File(pathDirectoryManyFolders)).size();
        assertEquals(17, size);
    }

    @Test
    public void listHasThreeDuplicatedList() {
        ObjectFile obj1 = new ObjectFile("name", "type", "path1", 222222222, 500);
        ObjectFile obj2 = new ObjectFile("name", "type", "path2", 222222222, 500);
        ObjectFile obj8 = new ObjectFile("name4", "type4", "path4", 10, 1500);
        ObjectFile obj4 = new ObjectFile("name", "type", "path2", 222222222, 500);
        ObjectFile obj3 = new ObjectFile("name3", "type3", "path3", 2111122, 1000);
        ObjectFile obj5 = new ObjectFile("name3", "type3", "path3", 2111122, 1000);
        ObjectFile obj6 = new ObjectFile("name4", "type4", "path4", 10, 1500);
        ObjectFile obj9 = new ObjectFile("name5", "type5", "path5", 5, 100);
        ObjectFile obj7 = new ObjectFile("name4", "type4", "path4", 10, 1500);
        List<ObjectFile> fullList = new ArrayList<ObjectFile>();
        fullList.add(obj1);
        fullList.add(obj7);
        fullList.add(obj1);
        fullList.add(obj2);
        fullList.add(obj8);
        fullList.add(obj3);
        fullList.add(obj4);
        fullList.add(obj5);
        fullList.add(obj6);
        fullList.add(obj9);

        List<List<ObjectFile>> duplicateList = ListWithDuplicatesLists.createListOfDuplicatedLists(fullList, "type");
        assertEquals(3, duplicateList.size());
    }

    @Test
    public void listHas2DuplicatedListTheSameName() {
        ObjectFile obj1 = new ObjectFile("name1", "type", "path1", 222222222, 500);
        ObjectFile obj2 = new ObjectFile("name2", "type", "path2", 222222222, 500);
        ObjectFile obj8 = new ObjectFile("name3", "type4", "path4", 10, 1500);
        ObjectFile obj4 = new ObjectFile("name8", "type", "path2", 222222222, 500);
        ObjectFile obj3 = new ObjectFile("name5", "type3", "path3", 2111122, 1000);
        ObjectFile obj5 = new ObjectFile("name1", "type3", "path3", 2111122, 1000);
        ObjectFile obj6 = new ObjectFile("name7", "type4", "path4", 10, 1500);
        ObjectFile obj9 = new ObjectFile("name8", "type5", "path5", 5, 100);
        ObjectFile obj7 = new ObjectFile("name8", "type4", "path4", 10, 1500);
        List<ObjectFile> fullList = new ArrayList<ObjectFile>();
        fullList.add(obj1);
        fullList.add(obj7);
        fullList.add(obj1);
        fullList.add(obj2);
        fullList.add(obj8);
        fullList.add(obj3);
        fullList.add(obj4);
        fullList.add(obj5);
        fullList.add(obj6);
        fullList.add(obj9);

        List<List<ObjectFile>> duplicateList = ListWithDuplicatesLists.createListOfDuplicatedLists(fullList, "name");
        assertEquals(2, duplicateList.size());
    }

    @Test
    public void listHas1DuplicatedListTheSameNameWith2Elements() {

        ObjectFile obj8 = new ObjectFile("name3", "type4", "path4", 10, 1500);
        ObjectFile obj4 = new ObjectFile("name8", "type", "path2", 222222222, 500);
        ObjectFile obj3 = new ObjectFile("name5", "type3", "path3", 2111122, 1000);
        ObjectFile obj5 = new ObjectFile("name1", "type3", "path3", 2111122, 1000);
        ObjectFile obj6 = new ObjectFile("name7", "type4", "path4", 10, 1500);
        ObjectFile obj9 = new ObjectFile("name8", "type5", "path5", 5, 100);
        ObjectFile obj7 = new ObjectFile("name8", "type4", "path4", 10, 1500);
        List<ObjectFile> fullList = new ArrayList<ObjectFile>();
       // fullList.add(obj7);
        fullList.add(obj8);
        fullList.add(obj3);
        fullList.add(obj4);
        fullList.add(obj5);
        fullList.add(obj6);
        fullList.add(obj9);

        List<List<ObjectFile>> duplicateList = ListWithDuplicatesLists.createListOfDuplicatedLists(fullList, "name");
        assertEquals(1, duplicateList.size());
        List<ObjectFile> objectFileList = duplicateList.get(0);
        assertEquals(2, objectFileList.size());
    }

}
