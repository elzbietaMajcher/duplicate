package com.em.dups;


import com.em.dups.internal.DataFactory;
import com.em.dups.internal.AFile;
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
//TODO: how to make fake folder with subfolder-s and files to test?
    // !!! don t worry about it aws you have to build logic on the LIst<AFile> so where it comes from here is not  important

    DuplicatesMap scenarioOne = new DuplicatesMap();
    AFile aFile = new AFile();
    DataFactory dataFactory = new DataFactory();
    List<AFile> allList = dataFactory.createObjects1();
    List<AFile> allList2 = dataFactory.createObjects2();


    @Test
    public void divideStringToTwoWordAndShowFirst() {
        String fullName = "name.type";
        String name = "name";
        assertEquals(name, AFile.extractName(fullName));
    }

    @Test
    public void testDoMapScenarioEmptyArray() {
        List<AFile> empty = new ArrayList<>();
        Map<String, List<AFile>> maps = scenarioOne.doMap(empty, infoType.name);
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneElement() {
        List<AFile> one = new ArrayList<>();
        AFile ob = new AFile("n", "t", "p1", 1, 1);
        one.add(ob);
        Map<String, List<AFile>> maps = scenarioOne.doMap(one, infoType.name);
        assertEquals(0, maps.size());
    }

    @Test
    public void testDoMapScenarioOneTheSameName() {
        Map<String, List<AFile>> maps = scenarioOne.doMap(allList, infoType.name);
        assertEquals(1, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameName() {
        Map<String, List<AFile>> maps = scenarioOne.doMap(allList2, infoType.name);
        assertEquals(2, maps.size());
    }

    @Test
    public void testDoMapScenarioTheSameExtension() {
        Map<String, List<AFile>> maps = scenarioOne.doMap(allList2, infoType.type);
        assertEquals(3, maps.size());
    }

    @Test
    public void testDoDuplicateListTheSameExtension() {
        AFile aFile = new AFile("t", "t3");
        List<AFile> result = scenarioOne.doDuplicateList(allList, aFile, infoType.type);
        assertEquals(2, result.size());
    }

    @Test
    public void divideStringToTwoWordAndShowSecond() {
        String fullName = "name.type";
        String type = "type";
        assertEquals(type, AFile.extractType(fullName));
    }

    @Test
    public void divideStringInLastDotAndShowType() {
        String fullName = "name.restName.stillName.type";
        String type = "type";
        assertEquals(type, AFile.extractType(fullName));
    }

    @Test
    public void divideStringToTwoWordsAndShowName() {
        String fullName = "name.restName.stillName.type";
        String name = "name.restName.stillName";
        assertEquals(name, AFile.extractName(fullName));
    }

    @Test
    public void checkIfListHasOneObject() {
        File folder = new File(pathDirectoryOneFile);
        List<File> array = new ArrayList<File>();
        List<File> list = AFile.listFilesForFolder(folder, array);
        assertEquals(1, list.size());
    }

    @Test
    public void checkIfFileListHas17files() {
        File folder = new File(pathDirectoryManyFolders);
        ArrayList<File> array = new ArrayList<File>();
        List<File> list = AFile.listFilesForFolder(folder, array);
        assertEquals(17, list.size());
    }

    @Test
    public void checkIfObjectListHas17files() {
        long count = AFile.makeObjectFilesList(new File(pathDirectoryManyFolders)).size();
        assertEquals(17, count);
    }

}
