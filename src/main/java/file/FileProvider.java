package file;

import com.google.common.io.Files;
import file.exceptions.FileNotFoundException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileProvider {

    private static final String FILENAME = "transactions";
    private static final String FILE_EXTENSION = "txt";

    public List<String> readFile() throws IOException, FileNotFoundException {
        URL url = getClass().getClassLoader().getResource(FILENAME + "." + FILE_EXTENSION);
        if (url == null) {
            throw new FileNotFoundException("Transactions file not found.");
        }
        File file = new File(url.getFile());
        return Files.readLines(file, StandardCharsets.UTF_8);
    }

}
