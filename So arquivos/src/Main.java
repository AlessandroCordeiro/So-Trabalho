import java.io.IOException;

public class Main {
    private static final String JOURNAL_FILE = "journal.log";

    public static void main(String[] args) {
        Journal.init(JOURNAL_FILE);

        try {
            // Exemplos de chamadas de métodos
            FileOperations.createDirectory("testDir");
            FileOperations.createFile("testDir/testFile.txt");
            FileOperations.listFiles("testDir");
            System.out.println("------------------------------------------------------------");
            FileOperations.copyFile("testDir/testFile.txt", "testDir/copiedFile.txt");
            FileOperations.renameFile("testDir/copiedFile.txt", "testDir/renamedFile.txt");
            FileOperations.listFiles("testDir");
            System.out.println("------------------------------------------------------------");
            FileOperations.deleteFile("testDir/renamedFile.txt");
            FileOperations.deleteDirectory("testDir");
            FileOperations.listFiles("testDir");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
