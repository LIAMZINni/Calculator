package Calculater;

import Calculater.Controller;
import Calculater.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    Model calculator=new Model();
    Scanner in=new Scanner(System.in);
    List<String> list=new ArrayList<>();

    public  void menu() throws IOException {









            System.out.println("1-Ввести новый пример "+"\n"+"2-Вывести старый пример"+"\n"+"3-history"+"\n"+"4-выход");
            int num=in.nextInt();
                switch (num){
                case 1->newPrimer();
                case 2->oldPrimer();
                case 3-> System.out.println(Controller.printHistory("history.txt"));
                case 4->saveLastSession();
                    default -> System.out.println("Команда не найдена  ");

            }




    }
    public  void newPrimer() throws IOException {
        System.out.print("Введите выражение -");
        String stroka = in.next();
        Controller.write(calculator.calculator(stroka));
        Controller.writeHistory(calculator.calculator(stroka),"history.txt");
        list.add(calculator.calculator(stroka));
        System.out.println(Controller.print());

    }
    public void oldPrimer() throws IOException {
        System.out.print("virachenire ="+Controller.getVirachenie(Controller.print()));
        String str=in.next();
        Controller.write(calculator.calculator(Controller.getVirachenie(String.valueOf(Controller.print()))+str));
        Controller.writeHistory(calculator.calculator(Controller.getVirachenie(String.valueOf(Controller.print()))),"history.txt");
        list.add(Controller.getVirachenie(String.valueOf(Controller.print()))+str);
        System.out.println(Controller.print());
    }
    public void saveLastSession(){
        System.out.println("Куда сохранить текущую сессию 1- в свой файл 2- в файл по умалчанию ");
        int num=in.nextInt();
        if(num==2){
            Controller.addLastSession(list,"last_session.txt");
            System.exit(0);
        }
        if(num==1){
            System.out.println("Введите имя файла ");
            String file=in.next();
            Controller.addLastSession(list,file);
            System.exit(0);


        }
        else System.err.println("команда не найдена ");


    }


}

