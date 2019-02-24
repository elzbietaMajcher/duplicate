package duplicate;


import java.io.File;


import java.util.ArrayList;
import java.util.List;


public class AllFileList {

    private List<ObjectFile> allFilesList;

    public AllFileList() {
    }

    public List<ObjectFile> getAllFilesList() {
        return allFilesList;
    }

    public void setAllFilesList(List<ObjectFile> allFilesList) {
        this.allFilesList = allFilesList;
    }
    //    public static void main(String[] args) throws IOException {
//        String pathDirectory = "C:\\mój komputer\\folder_testowy";
//
//        File folder = new File(pathDirectory);
//
//
//        System.out.println("----------------------------");
//        ArrayList<File> array = new ArrayList<File>();
//        System.out.println(listFilesForFolder(folder, array).size());
//    }
///////////////////////////////////////////////////////////////////////////////////////////////////



    public static List<File> listFilesForFolder(final File folder, List<File> fileArrayList) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, fileArrayList);
            } else {
                fileArrayList.add(fileEntry);
            }
        }
        return fileArrayList;
    }

    public static List<ObjectFile> makeObjectFilesList(File folder) {
        List<ObjectFile> objectFilesList = new ArrayList<ObjectFile>();
        List<File> fileArrayList = new ArrayList<File>();
        List<File> createdList = listFilesForFolder(folder, fileArrayList);
        for (File f : createdList) {
            ObjectFile objectFile = ObjectFile.createObject(f);
            objectFilesList.add(objectFile);
        }
        return objectFilesList;
    }
}
