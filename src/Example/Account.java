public class Account {
    // 필드
    int balance;

    // 생성자
    public Account(int balance) {
        this.balance = balance;
    }

    // 메소드
    public String toString() {
        return String.format("Account { balance: %d }", balance);
    }
}