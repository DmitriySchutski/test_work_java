import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите арифметическое выражение (например, 1 + 2):");
            String input = scanner.nextLine();
            try {
                String result = calc(input);
                System.out.println("Output:");
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Output:");
                System.out.println("throws Exception");
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new Exception("Неверный формат выражения");
        }

        int a, b;
        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат числа");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }

        String operator = tokens[1];
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("Неверная арифметическая операция");
        }

        return String.valueOf(result);
    }
}