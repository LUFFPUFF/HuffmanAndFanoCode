package logic.util;

import java.io.FileWriter;
import java.io.IOException;


public class Writer {

    public static void writeToTxtFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Текстовое решение успешно сохранено в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
