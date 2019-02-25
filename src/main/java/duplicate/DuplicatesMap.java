package duplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DuplicatesMap {

    private Map<String, List<ObjectFile>> duplicates;

    public Map<String, List<ObjectFile>> getDuplicates() {
        return duplicates;
    }

    public List<ObjectFile> doDuplicateList(List<ObjectFile> allFiles, ObjectFile objectFile, String info) {
        List<ObjectFile> result = new ArrayList<>();
        for (ObjectFile o : allFiles) {
            if (checkIfHasTheSame(o, objectFile, info)) {
                result.add(o);
            }
        }
        return result;
    }

    public Map<String, List<ObjectFile>> doMap(List<ObjectFile> allFiles, String info) {
        Map<String, List<ObjectFile>> maps = new HashMap<>();
        final List<ObjectFile> helper = allFiles;
        helper.forEach(o -> {
                    List<ObjectFile> list = doDuplicateList(helper, o, info);
                    if (list.size() > 1) {
                        String name = list.get(0).getName();
                        maps.put(name, list);
                    }
                }
        );
        return maps;

    }

    private static boolean checkIfHasTheSame(ObjectFile objectFile1, ObjectFile objectFile2, String info) {
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
