//Create by Yaroslav Denisov for Kata Academy
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] sign = {"+", "-", "/", "*"};
        String[] sideSign = {"\\+", "-", "/", "\\*"};
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = input.nextLine();
        int actionIndex=-1;
        for (int i = 0; i < sign.length; i++) {
            if(exp.contains(sign[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("throws Exception");
            return;
        }
        String[] data = exp.split(sideSign[actionIndex]);
        if(converter.roman(data[0]) == converter.roman(data[1])){
            int a,b;
            boolean thisRoman = converter.roman(data[0]);
            if(thisRoman){ a = converter.romanToArab(data[0]); b = converter.romanToArab(data[1]); }
            else{ a = Integer.parseInt(data[0]); b = Integer.parseInt(data[1]); }

            int result = 0;
            switch (sign[actionIndex]) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;
                default -> System.out.println("throws Exception");
            }
            if(thisRoman){
                System.out.println(converter.arabToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }
    }
}
