package main.java;

import java.io.*;
import java.nio.Buffer;
import java.util.function.UnaryOperator;

public class FileConverter {
    private ROT rot;
    private BufferedReader file;
    public FileConverter(ROT rot) {
        this.rot = rot;
    }
    public void readInFile(String pathname) throws FileNotFoundException {
        try {
            file = new BufferedReader(new FileReader(new File(pathname)));
        } catch (IOException e) {
            throw new FileNotFoundException("No file found at" + pathname);
        }
    }

    public void decryptFile(String decryptedFileName) throws FileNotFoundException{
        cryptFile(decryptedFileName, (a) -> rot.decrypt(a));
    }

    public void encryptFile(String encryptedFileName) throws FileNotFoundException{
        cryptFile(encryptedFileName, (a) -> rot.encrypt(a));
    }

    private void cryptFile(String encryptedFileName, final UnaryOperator<String> operator) throws FileNotFoundException {
        try {
        FileWriter newFile = new FileWriter(encryptedFileName);
        String line;
        while ((line = file.readLine()) != null) {
            newFile.write(operator.apply(line) + "\n");
        }
            newFile.close();
        } catch (IOException | NullPointerException e) {
            throw new FileNotFoundException("Please read in file first");
        }
    }

}
