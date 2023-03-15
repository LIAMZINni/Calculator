package Calculater;

import Calculater.Controller;
import Calculater.Model;

import java.io.IOException;
import java.util.Scanner;

public class View {
    Model calculator=new Model();
    Scanner in=new Scanner(System.in);
    public  void menu() throws IOException {
        Scanner in=new Scanner(System.in);
        Model calculator=new Model();






            System.out.println("1-Ввести новый пример "+"\n"+"2-Вывести старый пример"+"\n"+"3-выход");
            int num=in.nextInt();
                switch (num){
                case 1->newPrimer();
                case 2->oldPrimer();
                case 3->System.exit(0);
                    default -> System.out.println("Команда не найдена  ");

            }




    }
    public  void newPrimer() throws IOException {
        System.out.print("Введите выражение -");
        String stroka = in.next();
        Controller.write(calculator.calculator(stroka));
        System.out.println(Controller.print());

    }
    public void oldPrimer() throws IOException {
        System.out.print("virachenire ="+Controller.getVirachenie(Controller.print()));
        String str=in.next();
        Controller.write(calculator.calculator(Controller.getVirachenie(Controller.print())+str));
        System.out.println(Controller.print());
    }

}

