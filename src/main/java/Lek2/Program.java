package Lek2;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Program {
    public static void main(String[] args){
        FileReader test=null;
        try {
            test = new FileReader("F:\\geekbrains\\Geekbrains\\ErrorsWorking\\.gitignore");
            //test.read();
        } catch (RuntimeException | IOException e){
            System.out.println("catch exeption "+ e.getClass().getSimpleName());
        } finally {
            if (test!= null){
                try {
                    test.close();

                } catch (IOException e) {System.out.println("exeotion while close");}
            }
        }
    }
}
