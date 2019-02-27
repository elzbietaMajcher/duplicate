package duplicate;


import java.io.File;
import java.util.*;

public class ObjectFile {
    private String name;
    private String type;
    private String path;
    private long lastModification;
    private long sizeInBytes;

    public ObjectFile(String name, String type, String path, long lastModification, long sizeInBytes) {
        this.name = name;
        this.type = type;
        this.path = path;
        this.lastModification = lastModification;
        this.sizeInBytes = sizeInBytes;
    }

    public ObjectFile(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ObjectFile() {

    }

    public ObjectFile(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectFile{" +
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

    public static ObjectFile createObject(File fileEntry) {
        String fullName = fileEntry.getName();
        String name = extractName(fullName);
        String type = extractType(fullName);
        String path = fileEntry.getPath();
        long lastModification = fileEntry.lastModified();
        long size = fileEntry.length();
        ObjectFile objectFile = new ObjectFile(name, type, path, lastModification, size);
        return objectFile;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectFile that = (ObjectFile) o;
        return lastModification == that.lastModification &&
                sizeInBytes == that.sizeInBytes &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, lastModification, sizeInBytes);
    }

    public boolean equalsName(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectFile that = (ObjectFile) o;
        return Objects.equals(name, that.name);
    }

    public boolean equalsSize(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectFile that = (ObjectFile) o;
        return sizeInBytes == that.sizeInBytes;
    }

    public boolean equalsType(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectFile that = (ObjectFile) o;
        return Objects.equals(type, that.type);
    }

}
