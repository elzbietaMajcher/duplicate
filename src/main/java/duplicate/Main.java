package duplicate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String info = "";
        String inPath; //= "src\\test\\resources\\folder_testowy";
        //String path2 = "C"; //is not a folder ---> throw exception
        String outPath; //= "src\\test\\resources\\test" + ".txt";


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("To start searching duplicated files: \n" +
                    "1.copy the folder path:");

            inPath = scanner.nextLine();

            System.out.println("2.to save output enter path with new file name:");

            outPath = scanner.nextLine() + ".txt";

            System.out.println("3.Choose strategy of searching:");
            System.out.println("name");
            System.out.println("type");
            System.out.println("size");

            info = scanner.nextLine();

            long start = System.currentTimeMillis();
            searchDuplicates(inPath, info, outPath);
            long stop = System.currentTimeMillis();
            System.out.println("Time in milliseconds: " + ((stop - start)));

        } catch (InputMismatchException e) {
            System.out.printf("%nException: %s%n", e);
            System.out.println("You must enter correct strategy.");
        } catch (NullPointerException e) {
            System.out.printf("%nException: %s%n", e);
            System.out.println("You must enter correct input or output path.");
        }

    }

    public static void searchDuplicates(String inPath, String info, String outPath) {
        if (info.equals("name") || info.equals("type") || info.equals("size")) {
            DuplicatesMap duplicatesMap = new DuplicatesMap();
            AllFileList allFileList = new AllFileList();
            File folder = new File(inPath);

            List<ObjectFile> allList = allFileList.makeObjectFilesList(folder);

            Map<String, List<ObjectFile>> duplicates = duplicatesMap.doMap(allList, info);
            showDuplicates(duplicates);
            saveToExternalFile(duplicates, inPath, outPath);
        } else throw new InputMismatchException();
    }

    //TODO: communication with user: user can choose folder to search, output listed result of duplicated map,example: keyName1 , keyName2 , KeyName3;

    private static void showDuplicates(Map<String, List<ObjectFile>> duplicates) {
        for (Map.Entry<String, List<ObjectFile>> l : duplicates.entrySet()) {
            String key = l.getKey();
            System.out.println(key + ": [");
            List<ObjectFile> value = l.getValue();
            value.forEach(v -> System.out.println(v));
            System.out.println("]");
        }
    }

    private static void saveToExternalFile(Map<String, List<ObjectFile>> map, String inPath, String outPath) {

        try (FileWriter fw = new FileWriter(outPath)) {
            fw.write("Given folder path: " + inPath + ":\n");
            for (Map.Entry<String, List<ObjectFile>> l : map.entrySet()) {
                String key = l.getKey();
                fw.write(key + ": [\n");
                List<ObjectFile> value = l.getValue();
                value.forEach(v -> {
                    try {
                        fw.write(v.toString() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fw.write("]\n");
            }
        } catch (IOException e) {
            System.out.printf("%nException: %s%n", e);
            System.out.println("Input or output exception.");
        }
    }
}
