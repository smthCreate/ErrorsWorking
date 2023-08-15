package Sem3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        registration();
    }

    private static void registration() {
        String input  = inputing();
        String[] splString = input.split(" ");
        if (splString.length==6){
            String FIO = splString[0]+" "+splString[1]+" "+splString[2];
            try {
                Date date = convertingDate(splString[3]);
                Long number = Long.parseLong(splString[4]);
                if (splString[5].equals("f")||splString[5].equals("m")){
                    String fileName = "F:\\geekbrains\\Geekbrains\\ErrorsWorking\\src\\main\\java\\Sem3\\"+FIO+".txt";
                    Path path = Paths.get(fileName);
                    String content = (FIO+", "+splString[3]+", "+splString[4]+", "+splString[5]);
                    File folder  = new File("F:\\geekbrains\\Geekbrains\\ErrorsWorking\\src\\main\\java\\Sem3");
                    File[] allFiles = folder.listFiles();
                    for (File file:
                         allFiles) {
                        if (file.getName().split(" ")[0].equalsIgnoreCase(splString[0])){
                            appendingIntoFile(file.getPath(),content);
                            break;
                        }else {
                            creatinFile(fileName,content);
                        }
                    }


                }else {
                    throw new Exception("Incorrect sex");
                }

            } catch (ParseException e) {
                System.out.println("Date is wrong: "+e.getMessage());
                System.out.println("New registration session");
                registration();
            } catch (NumberFormatException e){
                System.out.println("Number is wrong: "+e.getClass().getSimpleName());
                System.out.println("New registration session");
                registration();
            } catch (Exception e){
                System.out.println("New registration session: "+e.getClass().getSimpleName());
                registration();
            }
        } else {
            System.out.println("Incorect data. Repeate try");
            registration();
        }

    }

    private static void creatinFile(String path, String content) {
        File file = new File(path);
        try {
            if (file.createNewFile()){
                System.out.println("File was created: "+file.getAbsolutePath());
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e){
            System.out.println("Exception: "+e.getClass().getSimpleName());
            String resAns = inputingMes("Do you want to retry?(Y/N)");
            if (resAns.equalsIgnoreCase("y")){
                registration();
            }
        }

    }

    private static void appendingIntoFile(String path, String content) {
        File file  = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.append("\n"+content);
        } catch (IOException e){
            System.out.println("Exception: "+e.getClass().getSimpleName());
            String resAns = inputingMes("Do you want to retry?(Y/N)");
            if (resAns.equalsIgnoreCase("y")){
                registration();
            }
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e){
                System.out.println("File was not closed: "+e.getClass().getSimpleName());
            } catch (NullPointerException e){
                System.out.println("FileWriter was not created: "+e.getClass().getSimpleName());
            }
        }
    }

    private static Date convertingDate(String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.parse(s);
    }

    private static String inputing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input here: ");
        String input;
        if (scanner.hasNext()){
            input = scanner.nextLine();
        }else{
            System.out.println("Ошибка. Повторите ввод операции");
            scanner.next();
            input = inputing();
        }
        return input;
    }
    private static String inputingMes(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input here: ");
        String input;
        if (scanner.hasNext()){
            input = scanner.nextLine();
        }else{
            System.out.println("Ошибка. Повторите ввод операции");
            scanner.next();
            input = inputing();
        }
        return input;
    }
}
