package file;

import file.exceptions.FileNotFoundException;
import file.exceptions.InvalidOperationOnDataException;
import model.Operation;
import model.OperationType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    private final List<Operation> operationList;

    public FileParser() throws FileNotFoundException, IOException {
        operationList = new ArrayList<>();
        parseFile();
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    private void parseFile() throws FileNotFoundException, IOException {
        FileProvider fileProvider = new FileProvider();
        String regex = "([R|W]\\([a-z]\\))?\\|([R|W]\\([a-z]\\))?\\|([R|W]\\([a-z]\\))?";
        final Pattern pattern = Pattern.compile(regex);
        List<String> fileContent = fileProvider.readFile();
        fileContent.forEach(line -> {
            final Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    if (matcher.group(i) != null) {
                        try {
                            parseOperationOnDataString(i, matcher.group(i));
                        } catch (InvalidOperationOnDataException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void parseOperationOnDataString(int transaction, String operation) throws InvalidOperationOnDataException {
        String operationType = operation.substring(0, 1);
        String data = operation.substring(2, 3);
        if (operationType.equals("R")) {
            operationList.add(new Operation(transaction, OperationType.READ, data));
        } else if (operationType.equals("W")) {
            operationList.add(new Operation(transaction, OperationType.WRITE, data));
        } else {
            throw new InvalidOperationOnDataException("Invalid operation on data");
        }
    }
}
