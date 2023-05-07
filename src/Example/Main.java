public class Main {
    public static void main (String[] args) {
        // 1. 계좌 생성
        Account myAccount = new Account(1000000);
        System.out.println(myAccount.toString());

        // 2. 계좌 해킹
        Hacker.malcious(myAccount);

        // 3. 결과 출력
        System.out.println(myAccount.toString());
    }
}