package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 연산 기호와 숫자를 입력 받습니다.
        System.out.print("사칙 연산 기호를 입력하세요 (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("첫 번째 숫자를 입력하세요: ");
        double num1 = scanner.nextDouble();
        System.out.print("두 번째 숫자를 입력하세요: ");
        double num2 = scanner.nextDouble();

        // switch 문을 사용하여 입력된 연산 기호에 따라 적절한 연산을 수행합니다.
        double result = 0;
        boolean error = false; // 오류 발생 여부를 나타내는 변수

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다.");
                    error = true; // 오류 발생
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("잘못된 연산 기호입니다. 사칙 연산 기호를 입력하세요 (+, -, *, /)");
                error = true; // 오류 발생
        }

        // 오류가 발생하지 않았을 경우에만 결과를 출력합니다.
        if (!error) {
            System.out.println("결과: " + (int) result);
//        int로 result 값 저장
//            변수선언


        }
    }
}
