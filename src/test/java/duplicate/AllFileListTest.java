package duplicate;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AllFileListTest {

//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();


    private String pathDirectoryManyFolders = "src\\test\\resources\\folder_testowy";
    private String pathDirectoryOneFile = "src\\test\\resources\\folder_testowy\\Nowy folder";
//TODO: how to make fake folder with subfolder-s and files to test?

    private AllFileList allFileList = new AllFileList();


    @Test
    public void checkIfListHasOneObject() {
        //given
        File folder = new File(pathDirectoryOneFile);
        List<File> array = new ArrayList<>();
        //when
        List<File> list = allFileList.listFilesForFolder(folder, array);
        //then
        assertEquals(1, list.size());
    }

    @Test
    public void checkIfFileListHas17files() {
        //given
        File folder = new File(pathDirectoryManyFolders);
        ArrayList<File> array = new ArrayList<>();
        //when
        List<File> list = allFileList.listFilesForFolder(folder, array);
        //then
        assertEquals(17, list.size());
    }

    @Test
    public void checkIfAllFileListHas17files() {
        //given
        File folder = new File(pathDirectoryManyFolders);
        //when
        long count = allFileList.makeObjectFilesList(folder).size();
        //then
        assertEquals(17, count);
    }

    @Test
    public void wrongPathListFiles() {
        //given
        String wrongPath = "folder\\folder2\\folder3";
        //when
        try {
            File folder = new File(wrongPath);
            ArrayList<File> array = new ArrayList<>();
            List<File> list = allFileList.listFilesForFolder(folder, array);
            //then
            assertEquals(17, list.size());
        }catch (NullPointerException e){
            System.out.printf("%nException: %s%n", e);
            System.out.println("You must enter correct path.");
        }
    }

}
