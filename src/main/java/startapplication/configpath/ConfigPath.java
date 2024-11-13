package startapplication.configpath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ConfigPath {
    public static final String FILE_PATH_HUFFMAN = getOutputPath("huffman.png");
    public static final String FILE_PATH_FANO = getOutputPath("fano.png");
    public static final String FILE_PATH_TXT = getOutputPath("example.txt");

    private static String getOutputPath(String filename) {
        Path outputPath = Paths.get("src", "main", "java", "output");
        try {
            Files.createDirectories(outputPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create output directory", e);
        }

        return outputPath.resolve(filename).toString();
    }
}
