package com.em.dups.internal;


import java.io.File;
import java.util.*;


/**
 *
 */
public class AFile {
    private String name;
    private String type;
    private String path;
    private long lastModification;
    private long sizeInBytes;

    public AFile(String name, String type, String path, long lastModification, long sizeInBytes) {
        this.name = name;
        this.type = type;
        this.path = path;
        this.lastModification = lastModification;
        this.sizeInBytes = sizeInBytes;
    }

    public AFile(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public AFile() {

    }


    public AFile(String name) {
        this.name = name;
    }

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

    public static List<AFile> makeObjectFilesList(File folder) {
        List<AFile> aFilesList = new ArrayList<AFile>();
        List<File> fileArrayList = new ArrayList<File>();
        List<File> createdList = listFilesForFolder(folder, fileArrayList);
        for (File f : createdList) {
            AFile aFile = createObject(f);
            aFilesList.add(aFile);
        }
        return aFilesList;
    }

    @Override
    public String toString() {
        return "AFile{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", lastModification=" + lastModification +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLastModification() {
        return lastModification;
    }

    public void setLastModification(long lastModification) {
        this.lastModification = lastModification;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public static AFile createObject(File fileEntry) {
        String fullName = fileEntry.getName();
        String name = extractName(fullName);
        String type = extractType(fullName);
        String path = fileEntry.getPath();
        long lastModification = fileEntry.lastModified();
        long size = fileEntry.length();
        AFile aFile = new AFile(name, type, path, lastModification, size);
        return aFile;
    }

    public static String extractName(String fullName) {
        String[] full = fullName.split("\\.");
        int nameLength = full.length;
        String name = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nameLength - 1; i++) {
            name = stringBuilder.append(full[i]).toString();
            if (i < nameLength - 2) {
                name = stringBuilder.append(".").toString();
            }
        }
        return name;
    }

    public static String extractType(String fullName) {
        String[] full = fullName.split("\\.");
        int i = full.length;
        String type;
        type = full[i - 1];
        return type;

        //double [] re = new double[n];
    }

    public boolean equalsName(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AFile that = (AFile) o;
        return Objects.equals(name, that.name);
    }

    public boolean equalsModification(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AFile that = (AFile) o;
        return lastModification == that.lastModification;
    }

    public boolean equalsSize(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AFile that = (AFile) o;
        return sizeInBytes == that.sizeInBytes;
    }

    public boolean equalsPath(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AFile that = (AFile) o;
        return Objects.equals(path, that.path);
    }

    public boolean equalsType(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AFile that = (AFile) o;
        return Objects.equals(type, that.type);
    }

}
