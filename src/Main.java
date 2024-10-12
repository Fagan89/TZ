
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String primer = input.nextLine();
        try {
            String otvet = calculator(primer);
            output(otvet);
        } catch (Exception e) {
            System.out.println("введены некорректные данные");
        }

    }
    // Метод выбора операции и вызова соотвествующего метода операции с возвратом ответа.
    public static String calculator(String primer) throws  IllegalArgumentException{
        String otvet = "";
        if (primer.contains(" + ")) {
            String[] p1 = primer.split(" \\+ ");
            String one = p1[0];
            String three = p1[1];
            String[] oneArray = one.split("");
            String[] threeArray = three.split("");
            if (oneArray[0].equals("\"") && oneArray[one.length() - 1].equals("\"") && one.length() <= 12
                    && threeArray[0].equals("\"") && threeArray[three.length() - 1].equals("\"") && three.length() <= 12) {
                System.out.println("Данные введены верно. операция сложение");
                System.out.print("ответ: ");
                otvet = sum(one, three);
            } else {
                System.out.print("операция сложения. ");
                throw new IllegalArgumentException();
            }

        } else if (primer.contains(" - ")) {
            String[] p1 = primer.split(" - ");
            String one = p1[0];
            String three = p1[1];
            String[] oneArray = one.split("");
            String[] threeArray = three.split("");
            if (oneArray[0].equals("\"") && oneArray[one.length() - 1].equals("\"") && one.length() <= 12
                    && threeArray[0].equals("\"") && threeArray[three.length() - 1].equals("\"") && three.length() <= 12) {
                System.out.println("Данные введены верно. операция вычитания");
                System.out.print("ответ: ");
                otvet = delta(one, three);
            } else {
                System.out.print( "операция вычитания. " );
                 throw new IllegalArgumentException();
            }

        } else if (primer.contains(" / ")) {
            String[] p1 = primer.split(" / ");
            String one = p1[0];
            String three = p1[1];
            int threeProv = Integer.parseInt(three);
            String[] oneArray = one.split("");
            if (threeProv <= 10 && threeProv > 0 && oneArray[0].equals("\"") &&
                    oneArray[one.length() - 1].equals("\"") && one.length() <= 12) {
                System.out.println("Данные введены верно. операция вычитания");
                System.out.print("ответ: ");
                otvet = delit(one, three);
            } else {
                System.out.print("операция деления. ");
                throw new IllegalArgumentException();
                    }

        } else if (primer.contains(" * ")) {
            String[] p1 = primer.split(" \\* ");
            String one = p1[0];
            String three = p1[1];
            int threeProv = Integer.parseInt(three);
            String[] oneArray = one.split("");
            if (threeProv <= 10 && threeProv > 0 && oneArray[0].equals("\"") &&
                    oneArray[one.length() - 1].equals("\"") && one.length() <= 12) {
                System.out.println("Данные введены верно. операция умножения");
                System.out.print("ответ: ");
                otvet = umnozh(one, three);
            } else {
                System.out.print("операция умножения. ");
                throw new IllegalArgumentException("введены неккоретные данные для операции умножение");
            }

        } else {
            System.out.print("неподходящая операция. ");
            throw new IllegalArgumentException();
                }
        return otvet;
        }

    // Проверка и обработка выходных данных
    public static void output(String otvet) {
        if (otvet.length() > 40) {
            otvet = otvet.substring(0, 40);
            System.out.println("\"" + otvet + "..." + "\"");
        } else {
            System.out.println("\"" + otvet + "\"");
        }
    }

    // операция умножения
    public static String umnozh(String one, String three) {// операция умножение
        int three2 = Integer.parseInt(three);
        String one2 = one.replace("\"", "");
        String one3 = "";
        for (int i = 0; i < three2; i++) {
            one3 = one3 + one2;
        }
        return one3;
    }

// операция деления
    public static String delit(String one, String three) { // Операция деления
        int three2 = Integer.parseInt(three);
        String one2 = one.replace("\"", "");
        int l = one2.length();
        int m = l / three2;
        String[] one3 = one2.split("");
        String rez = new String("");
        for (int i = 0; i < m; i++) {
            rez = rez + one3[i];
        }
        return rez;
    }
// операция сложения
    public static String sum(String one, String three) { // Операция сложение
        String one2 = one.replace("\"", "");
        String three2 = three.replace("\"", "");
        String sum = new String(one2 + three2);
        return sum;
    }
// операция вычитания
    public static String delta(String one, String three) { // Операция вычитания
        String one2 = one.replace("\"", "");
        String three2 = three.replace("\"", "");
        String[] oneArray = one2.split(" ");
        String[] threeArray = three2.split(" ");
        int a = 0;
        for (int i = 1; i <= threeArray.length; i++) {
            if (threeArray[threeArray.length - i].equals(oneArray[oneArray.length - i])) {
                a++;
            }
        }
        String rez = new String("");
        if (a == threeArray.length) {
            for (int i = 0; i < (oneArray.length - threeArray.length); i++) {
                rez = rez + oneArray[i];
            }
        } else {
            rez = one2;
        }
        return rez;
    }
}


