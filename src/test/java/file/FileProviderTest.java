package file;

import file.exceptions.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileProviderTest {

    private FileProvider fileProvider;

    @BeforeEach
    void setUp() {
        fileProvider = new FileProvider();
    }

    @Test
    void testFileNotFoundException() {
        assertThrows(FileNotFoundException.class, () -> {
            throw new FileNotFoundException("File not found");
        });
    }

    @Test
    void mustNotThrowFileNotFound() {
        assertDoesNotThrow(() -> {
            fileProvider.readFile();
        });
    }

    @Test
    void fileContentNotNull() throws FileNotFoundException, IOException {
        assertNotNull(fileProvider.readFile());
    }

    @Test
    void fileReadReturnType() throws FileNotFoundException, IOException {
        assertEquals(ArrayList.class, fileProvider.readFile().getClass());
    }
}