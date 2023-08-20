package lek3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

public class Application {
    public static void main(String[] args) {
        try (FileReader file = new FileReader("F:\\geekbrains\\Geekbrains\\ErrorsWorking\\src\\main\\java\\Lek1\\123.txt");
             FileWriter writtenFile = new FileWriter("124")){
            while (file.ready()){
                writtenFile.write(file.read());
            }

        } catch (RuntimeException | IOException e){
            System.out.println("Ooops, exception: "+e.getClass().getSimpleName());
        }
    }

}
