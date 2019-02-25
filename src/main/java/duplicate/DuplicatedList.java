package duplicate;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedList {

    private List<ObjectFile> objectFileList;


    public List<ObjectFile> getObjectFileList() {
        return objectFileList;
    }

    public void setObjectFileList(List<ObjectFile> objectFileList) {
        this.objectFileList = objectFileList;
    }


    public static List<ObjectFile> createDuplicatedList(List<ObjectFile> objectFiles, String info){


        List<ObjectFile> duplicatedList = new ArrayList<>();
//przerobić kod

        return duplicatedList;
    }



    public static List<ObjectFile> createDuplicatedList(List<ObjectFile> fullList, int fullListElementIndex, String info) {

        // jedna metoda sortująca wg podanego "info" czyli wg nazwy, typu lub rozmiaru
        List<ObjectFile> duplicateList = new ArrayList<>();

        for (int j = (fullListElementIndex + 1); j < fullList.size(); j++) {
            boolean theSameType = checkIfHasTheSame(fullList.get(fullListElementIndex), fullList.get(j), info);
            if (theSameType) {
                if (duplicateList.isEmpty()) {
                    duplicateList.add(fullList.get(fullListElementIndex));
                }
                duplicateList.add(fullList.get(j));
            }
        }
        return duplicateList;
    }

    public static boolean checkIfHasTheSame(ObjectFile objectFile1, ObjectFile objectFile2, String info) {
        if (info == "type") {
            return objectFile1.equalsType(objectFile2);
        } else if (info == "name") {
            return objectFile1.equalsName(objectFile2);
        } else if (info == "sizeInBytes") {
            return objectFile1.equalsSize(objectFile2);
        }
        return false;
    }



}
