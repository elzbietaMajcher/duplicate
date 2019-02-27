package duplicate;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String info = "name";
        String path = "src\\test\\resources\\folder_testowy";
        String path2 = "C";


        try {
            long start = System.currentTimeMillis();
            showDuplicates(path, info);
            long stop = System.currentTimeMillis();
            System.out.println("Time in milliseconds: " + ((stop - start)));

            start = System.currentTimeMillis();
            showDuplicates(path2, info);
            stop = System.currentTimeMillis();
            System.out.println("Time in milliseconds: " + ((stop - start)));
        } catch (InputMismatchException e){
            System.out.printf("%nException: %s%n", e);
            System.out.println("You must enter correct strategy.");
        }catch (NullPointerException e) {
            System.out.printf("%nException: %s%n", e);
            System.out.println("You must enter correct path.");
        }

    }

    public static void showDuplicates(String path, String info) {
       if (info.equals("name") || info.equals("type") || info.equals("size")){
        DuplicatesMap duplicatesMap = new DuplicatesMap();
        AllFileList allFileList = new AllFileList();
        File folder = new File(path);

        List<ObjectFile> allList = allFileList.makeObjectFilesList(folder);

        Map<String, List<ObjectFile>> duplicates = duplicatesMap.doMap(allList, info);

        for (Map.Entry<String, List<ObjectFile>> l : duplicates.entrySet()) {
            String key = l.getKey();
            System.out.println(key + ": [");
            List<ObjectFile> value = l.getValue();
            value.forEach(v -> System.out.println(v));
            System.out.println("]");
        }
        }else throw new InputMismatchException();
    }
}
