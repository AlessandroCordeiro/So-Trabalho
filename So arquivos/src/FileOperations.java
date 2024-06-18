import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations {

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if (file.createNewFile()) {
            Journal.log("CREATE FILE: " + path);
        }
    }

    public static void copyFile(String sourcePath, String destPath) throws IOException {
        File source = new File(sourcePath);
        File dest = new File(destPath);
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Journal.log("COPY FILE: " + sourcePath + " TO " + destPath);
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            Journal.log("DELETE FILE: " + path);
        }
    }

    public static void renameFile(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        if (oldFile.renameTo(newFile)) {
            Journal.log("RENAME FILE: " + oldPath + " TO " + newPath);
        }
    }

    public static void createDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdir()) {
            Journal.log("CREATE DIRECTORY: " + path);
        }
    }

    public static void deleteDirectory(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        deleteFile(file.getPath());
                    } else {
                        deleteDirectory(file.getPath());
                    }
                }
            }
            if (dir.delete()) {
                Journal.log("DELETE DIRECTORY: " + path);
            }
        }
    }

    public static void renameDirectory(String oldPath, String newPath) {
        File oldDir = new File(oldPath);
        File newDir = new File(newPath);
        if (oldDir.renameTo(newDir)) {
            Journal.log("RENAME DIRECTORY: " + oldPath + " TO " + newPath);
        }
    }

    public static void listFiles(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
                Journal.log("LIST FILES IN DIRECTORY: " + path);
            }
        }
    }
}
