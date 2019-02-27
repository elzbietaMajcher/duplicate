package duplicate;


import java.io.File;


import java.util.ArrayList;
import java.util.List;


public class AllFileList {

    private List<ObjectFile> allFilesList;


    public List<ObjectFile> getAllFilesList() {
        return allFilesList;
    }


    public List<File> listFilesForFolder(final File folder, List<File> fileArrayList) {

            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry, fileArrayList);
                } else {
                    fileArrayList.add(fileEntry);
                }
            }
        return fileArrayList;
    }

    public List<ObjectFile> makeObjectFilesList(File folder) {
        List<ObjectFile> objectFilesList = new ArrayList<>();
        List<File> fileArrayList = new ArrayList<>();
        List<File> createdList = listFilesForFolder(folder, fileArrayList);
        for (File f : createdList) {
            ObjectFile objectFile = ObjectFile.createObject(f);
            objectFilesList.add(objectFile);
        }
        return objectFilesList;
    }
}
