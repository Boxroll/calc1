import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int result = evaluate(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int evaluate(String input) throws Exception {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new Exception("Invalid input format");
        }

        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[2]);
        char operator = tokens[1].charAt(0);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Введите корректное значение. Значения a и b должны быть от 1 до 10.");
        }
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new Exception("Division by zero");
                }
                return a / b;
            default:
                throw new Exception("Invalid operator");
        }
    }
}