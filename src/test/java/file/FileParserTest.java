package file;

import file.exceptions.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class FileParserTest {

    private FileParser fileParser;

    @BeforeEach
    void setUp() throws FileNotFoundException, IOException {
        fileParser = new FileParser();
    }

    @Test
    void getOperationList() {
        assertNotNull(fileParser.getOperationList());
    }

    @Test
    void testOperationListType() {
        assertEquals(ArrayList.class, fileParser.getOperationList().getClass());
    }

}