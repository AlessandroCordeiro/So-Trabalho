import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Journal {
    private static BufferedWriter writer;

    public static void init(String journalFile) {
        try {
            writer = new BufferedWriter(new FileWriter(journalFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String operation) {
        try {
            writer.write(operation);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
