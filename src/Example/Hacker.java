package Example;

public class Hacker {
    // 클래스 메소드 - 계좌의 잔액을 0원으로 변경
    Account  account = new Account(0);
    public static void malcious(Account account) {
        /* 1. 파라미터 계좌의 잔액을 0으로 변경하세요. */
        account.balace = 0;
    }
}