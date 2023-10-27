package lecture.week9;

import java.io.IOException;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            performFileOperation();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void performFileOperation() throws IOException {
        boolean fileExists = false;
        if (!fileExists) {
            throw new IOException("File not found");
        }
        System.out.println("File operation completed successfully.");
    }
}
