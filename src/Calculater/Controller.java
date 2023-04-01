package Calculater;

import com.sun.source.tree.BreakTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    Model model=new Model();
    File file =new File("primer.txt");
    //записывает в файл последний пример
    public static void write(String var)  {
        File file =new File("primer.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println(var);
    printWriter.close();

}

    //записывает в файл историю
    public static void writeHistory(String primer,String file){
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(primer + "\n");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Файл для записи не найден! " + e);
        }

    }
    //записывает последнюю сессию
    public static  void addLastSession(List<String>list ,String s)  {
        clearFile(s);
        for (String s1:list) {
            int i=0;
            writeHistory(list.get(i),s);

        }



    }
    //чистит содержимое
    public static void clearFile(String s)  {
        try {
            new FileWriter(s,false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //выводит историю
    public static List<String> printHistory(String file) {
        List<String> expressions = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            Scanner scannerReader = new Scanner(reader);

            while (scannerReader.hasNextLine()) {
                expressions.add((scannerReader.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Файл для чтения не найден! " + e);
        }

        return expressions;

    }
    //возвращает выражение до =
    public static String  getVirachenie(String s) {
        int index=s.indexOf("=");
        String answer=s.substring(0,index);
        return answer;


    }


    //возвращает пример из файла
    public static String print() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("primer.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));

        String line="";

        while ((line = fin.readLine()) != null) {

            return line;
        }


        return line;


    }


}
