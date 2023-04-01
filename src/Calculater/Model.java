package Calculater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Model {

    //переводит выражение в обратную польскую запись
    public List<String> pars(String leng){
        List<String> box=new ArrayList<>();
        Stack<Character>stack=new Stack<>();

        char symbol;
        String per="";
        int preoritet;
        for (int i = 0; i < leng.length(); i++) {

            symbol=leng.charAt(i);
            preoritet=getPreoritet(leng.charAt(i));
            if (isChislo(symbol)){
                per+=symbol;
                if (i==leng.length()-1||!isChislo(leng.charAt(i+1))){
                    box.add(per);
                    per="";
                }
            }
            else if(isOperation(symbol)){


            if(preoritet==1){
                stack.push(leng.charAt(i));

            }
            if(preoritet>1){
                while (!stack.empty()){
                    if(getPreoritet(stack.peek())>=preoritet){
                        box.add(String.valueOf(stack.pop()));

                    }
                    else break;
                }
                stack.push(symbol);
            }
            if(preoritet==-1){
                while (getPreoritet(stack.peek())!=1){
                    box.add(String.valueOf(stack.pop()));
                }
                stack.pop();

            }


        }}

        while (!stack.empty()){
            box.add(String.valueOf(stack.pop()));
        }
        return  box;
    }
    //выводит готовй пример
    public String calculator(String stroka){
        String otvet= String.valueOf(otvet(pars(stroka)));
        return stroka+"="+otvet;

    }


    public boolean isOperation(char s){
        if(s=='*'||s=='/'||s=='+'||s=='-'||s=='('||s==')'||s=='^'||s=='%')
            return true;


        return false;
    }
    //считает ответ
    public double otvet(List<String> primer){
        Stack<Double> stack=new Stack<>();
        double var;
        for (int i = 0; i <primer.size() ; i++) {



            switch (primer.get(i)){

                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;

                case "-":
                    var=stack.pop();
                    stack.push(stack.pop()-var);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    var=stack.pop();
                    stack.push(stack.pop()/var);
                    break;
                case "^":
                    var=stack.pop();
                    stack.push(Math.pow(stack.pop(),var));
                    break;
                case "%":
                    var=stack.pop();
                    stack.push(stack.pop()%var);
                    break;

                default:
                    stack.push(Double.valueOf(primer.get(i)));


            }

        }
        return stack.pop();
    }

    public boolean isChislo(char s){
        if(s>='0'&& s<='9'||s=='.'){return true;}
        return false;

        }



    //расставление приоритетов
    public int getPreoritet(char znak){
        if(znak=='^')return 4;
        else if (znak=='*' ||znak=='/'||znak=='%'){return 3;}
        else if (znak=='+'||znak=='-'){return 2;}
        else if (znak=='('){return 1;}
        else if (znak==')') {return -1;}
        else return 0;
    }


}
