package dev.bank.service;

import java.time.Month;
import java.util.List;

import dev.bank.domain.BankTransaction;

// service 패키지??
// 세 번째 관심사인 입출금 내역을 연산처리하는 역할(비즈니스 로직)을 담당하는 클래스
// 비즈니스 로직 -> 일반적으로 service라는 이름의 패키지에 관리
public class BankStatementProcessor {

	// Processor 클래스에서 자주 사용하기 때문에 별도의 필드로 구성
	private List<BankTransaction> bankTransactions;

	// Processor 인스턴스를 생성하는 과정에서 List<BankTransaction>도 같이 초기화
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	// 총 입출금 내역 조회
	public double calculateTotalAmount() {
		// 구현
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount(); // 금액 추출
		}
		return total;
	}

	public double calculateTotalInMonth(Month month) {
		double total = 0d;

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				total += bankTransaction.getAmount();
			}
		}

		return total;
	}

	// 카테고리 별 총 입출금액을 조회할 수 있는 메서드
	public double calculateTotalForCategory(String category) {
		double total = 0d;

		for (BankTransaction bankTransaction : bankTransactions) {
			String description = bankTransaction.getDescription();

			// equals() vs == 차이??
			if (description.equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}
}