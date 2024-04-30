package calculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[10];
//        intArray[3] = 10; 값 저장
//        intArray[index++] = (int) result;

        int index = 0;
        while (true) {
            // 사용자에게 연산 기호와 숫자를 입력 받습니다.
            System.out.print("사칙 연산 기호를 입력하세요 (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = scanner.nextInt();

            // switch 문을 사용하여 입력된 연산 기호에 따라 적절한 연산을 수행합니다.
            int result = 0;

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
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다. 사칙 연산 기호를 입력하세요 (+, -, *, /)");
            }

            if (index >= 10) {
                for (int i = 0; i < intArray.length - 1; i++) {            // intArray[0] = intArray[1];
                    intArray[i] = intArray[i + 1];                        // intArray[1] = intArray[2]
                }
                intArray[9] = result;
            }
            else {
                intArray[9] = result;
                index++;
            }

            System.out.println("결과: " + Arrays.toString(intArray));
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String pri = scanner.next();

            if (pri.equals("exit")) {
                break;
            }
        }
    }
}

