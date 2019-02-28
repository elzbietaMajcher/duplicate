package duplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DuplicatesMap {

    private Map<String, List<ObjectFile>> duplicates;
    private String key;
    private List<ObjectFile> objectFiles;

    public DuplicatesMap() {
    }

    public DuplicatesMap(Map<String, List<ObjectFile>> duplicates) {
        this.duplicates = duplicates;
    }

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
                        String name = createMapKey(info,list.get(0));
                        maps.put(name, list);
                    }
                }
        );
        return maps;
    }
    //method for map key scenario one object.getName, scenario two object.getType, scenario three object.get.size
    public static String createMapKey(String info, ObjectFile o) {
        String mapKey = "";
        if (info.equals("name")) return mapKey = o.getName();
        if (info.equals("type")) return mapKey = o.getType();
        if (info.equals("size")) return mapKey = String.valueOf(o.getSizeInBytes());
        return mapKey;
    }

    private static boolean checkIfHasTheSame(ObjectFile objectFile1, ObjectFile objectFile2, String info) {
        if (info.equals("type")) {
            return objectFile1.equalsType(objectFile2);
        } else if (info.equals("name")) {
            return objectFile1.equalsName(objectFile2);
        } else if (info.equals("size")) {
            return objectFile1.equalsSize(objectFile2);
        }
        return false;
    }

// TODO:  user can: choose key element of map to list value(output: "exactly the same"* and "potentially the same"**; all objectFile details + link path to open file)
// TODO: check if in given element of map object is "exactly the same)* (with different path
// //override equals() in ObjectFile class)
// user can subjectively compare output files and decide if or which one delete
}
