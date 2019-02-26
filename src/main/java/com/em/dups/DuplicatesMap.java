package com.em.dups;

import com.em.dups.internal.AFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 */
enum infoType { type, name,sizeInBytes}

/**
 *
 */
public class DuplicatesMap {

    private Map<String, List<AFile>> duplicates;

    public Map<String, List<AFile>> getDuplicates() {
        return duplicates;
    }

    /**
     * @param allFiles
     * @param aFile
     * @param info
     * @return
     */
    public List<AFile> doDuplicateList(List<AFile> allFiles, AFile aFile, infoType info) {
        List<AFile> result = new ArrayList<>();
        for (AFile o : allFiles) {
            if (checkIfHasTheSame(o, aFile, info)) {
                result.add(o);
            }
        }
        return result;
    }

    /**
     * @param allFiles
     * @param info
     * @return hashmap with ...
     */
    public Map<String, List<AFile>> doMap(List<AFile> allFiles, infoType info) {
        Map<String, List<AFile>> maps = new HashMap<>();
        final List<AFile> helper = allFiles;
        helper.forEach(o -> {
                    List<AFile> list = doDuplicateList(helper, o, info);
                    if (list.size() > 1) { // at least 2 match to say we have a duplicate
                        String name = list.get(0).getName();
                        maps.put(name, list);
                    }
                }
        );
        return maps;
//TODO: method for map key scenario one object.getName, scenario two object.getType, scenario three object.get.size
    }

    /**
     * @param aFile1
     * @param aFile2
     * @param info
     * @return true if they are the same othw false
     */
    private static boolean checkIfHasTheSame(AFile aFile1, AFile aFile2, infoType info) {
        if (info == infoType.type) {
            return aFile1.equalsType(aFile2);
        } else if (info == infoType.name) {
            return aFile1.equalsName(aFile2);
        } else if (info ==  infoType.sizeInBytes) {
            return aFile1.equalsSize(aFile2);
        }
        return false;
        /*
        //TODO rather use
        @Override
public boolean equals(AFile other){
...
*/
    }
//TODO: communication with user: user can choose folder to search, output listed result of duplicated map,example: keyName1 , keyName2 , KeyName3;
// TODO:  user can: choose key element of map to list value(output: "exactly the same"* and "potentially the same"**; all objectFile details + link path to open file)
// TODO: check if in given element of map object is "exactly the same)* (with different path - override equals() in AFile class)
//TODO: user can subjectively compare output files and decide if or which one delete
}
