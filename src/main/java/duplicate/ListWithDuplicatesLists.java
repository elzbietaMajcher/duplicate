package duplicate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListWithDuplicatesLists {
    private List<DuplicatedList> duplicatesFilesList;
//lista zawierająca listy zduplikowanych plików np lista plików typu .txt, lista plików typu .pdf


    public static List<List<ObjectFile>> createListOfDuplicatedLists(List<ObjectFile> fullList, String info) {
        List<List<ObjectFile>> list = new ArrayList<List<ObjectFile>>();
        for (int i = 0; i < fullList.size(); i++) {
            List<ObjectFile> objectFileList = DuplicatedList.createDuplicatedList(fullList, i, info);

            if (objectFileList.size() > 0 && list.isEmpty()) {
                list.add(objectFileList);
            } else if ((objectFileList.size() > 0 && !list.isEmpty())) {
                if (!checkPreviousList(list, objectFileList.get(1))) {
                    list.add(objectFileList);
                }
            }
        }
        return list;
    }

    private static boolean checkPreviousList(List<List<ObjectFile>> list, ObjectFile objectFile) {
        List<ObjectFile> objectFileList = new ArrayList<ObjectFile>();
        for (int i = 0; i < list.size(); i++) {
            List<ObjectFile> obj = list.get(i);
            for (int j = 0; j < obj.size(); j++) {
                objectFileList.add(obj.get(j));
            }
        }
        for (int i = 0; i < objectFileList.size(); i++) {
            if (objectFileList.get(i) == objectFile) {
                return true;
            }
        }
        return false;
    }

//    public static ArrayList<ObjectFile> createList(AllFileList allList) {
//       ArrayList<ObjectFile> list = ;
//
//        return list;
//    }
}
