import java.util.Scanner;
import java.lang.FunctionalInterface;



@FunctionalInterface
interface ICalculator {
    public double calc(double v1, double v2);
}



public class Calculator {


    public static void main(String[] args) {

        System.out.println("Simple calculator");
        System.out.println("");


        ICalculator sum = (v1, v2) -> v1 + v2;
        ICalculator sub = (v1, v2) -> v1 - v2;
        ICalculator mul = (v1, v2) -> v1 * v2;
        ICalculator div = (v1, v2) -> v1 / v2;


        Scanner in = new Scanner(System.in);

        boolean quit = false;


        double v1;
        double v2;
        String operator;
        double result = 0;

        do {

            System.out.println("Enter first digit:");
            while(true) {
                if (in.hasNextDouble()) {
                    v1 = in.nextDouble();
                    break;
                } else {
                    System.out.println("Error! Enter correct digit!");
                    in.nextLine();
                }
            }



            System.out.println("Enter operator from list: +,-,*,/");
            while(true) {
                try{
                    operator = in.next();


                    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") )
                        break;
                    else System.out.println("Error! Enter correct operator from list: +,-,*,/");

                }catch (Exception e){
                    System.out.println("Error! Enter correct operator!");
                    in.nextLine();
                }
            }



            System.out.println("Enter second digit:");
            while(true) {
                if (in.hasNextDouble()) {
                    v2 = in.nextDouble();
                    break;
                } else {
                    System.out.println("Error! Enter correct digit!");
                    in.nextLine();
                }
            }





            switch (operator) {

                case "+":
                    result = sum.calc(v1, v2);
                    break;

                case "-":
                    result = sub.calc(v1, v2);
                    break;

                case "*":
                    result = mul.calc(v1, v2);
                    break;

                case "/":
                    result = div.calc(v1,v2);
                    break;
            }


            System.out.println("Result: " + result);



            System.out.println("Quit? y/n");
            String q = in.next();

            if (q.equals("y")) quit = true;


            System.out.println("");


        } while (!quit);

        in.close();
        System.out.println("Bye-bye");

    }
}