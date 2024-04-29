package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_RESULTS = 10;
        double[] results = new double[MAX_RESULTS]; // 연산 결과를 저장할 배열 선언 및 생성
        int count = 0; // 연산 결과를 저장한 횟수를 나타내는 변수

        // 무한 반복을 위한 while 루프
        while (true) {
            // 사용자에게 연산 기호와 숫자를 입력 받습니다.
            System.out.print("사칙 연산 기호를 입력하세요 (+, -, *, /), 또는 'exit'을 입력하여 종료하세요: ");
            String input = scanner.nextLine();

            // 사용자가 "exit"을 입력하면 프로그램을 종료합니다.
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 입력된 문자열을 공백을 기준으로 분리하여 연산 기호와 숫자를 추출합니다.
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                System.out.println("잘못된 입력입니다. 연산 기호와 숫자를 정확히 입력하세요.");
                continue; // 다음 반복으로 넘어감
            }

            char operator = tokens[0].charAt(0);
            double num1, num2;
            try {
                num1 = Double.parseDouble(tokens[1]);
                num2 = Double.parseDouble(tokens[2]);
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 올바르지 않습니다.");
                continue; // 다음 반복으로 넘어감
            }

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

            // 오류가 발생하지 않았을 경우에만 결과를 출력하고 배열에 저장합니다.
            if (!error) {
                System.out.println("결과: " + result);
                if (count < MAX_RESULTS) {
                    results[count] = result; // 배열에 연산 결과 저장
                    count++; // 카운트 증가
                } else {
                    System.out.println("더 이상 연산 결과를 저장할 공간이 없습니다.");
                }
            }
        }

        // 저장된 연산 결과 출력
        System.out.println("\n저장된 연산 결과:");
        for (int i = 0; i < count; i++) {
            System.out.println("결과 " + (i + 1) + ": " + results[i]);
        }

        scanner.close(); // 스캐너를 닫습니다.
    }
}


