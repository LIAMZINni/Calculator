package Calculater;

import com.sun.source.tree.BreakTree;

import java.io.*;
import java.util.Scanner;

public class Controller {
    Model model=new Model();
    File file =new File("primeri");
    //записывает в файл выражение
    public static void write(String var)  {
        File file =new File("primeri");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println(var);
    printWriter.close();





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
        File f = new File("primeri");
        BufferedReader fin = new BufferedReader(new FileReader(f));

        String line="";

        while ((line = fin.readLine()) != null) {

            return line;
        }


        return line;


    }


}
