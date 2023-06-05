package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// data패키지 - 외부 데이터와 관련된 역할을 하는 패키지

// 읽어들인 TSV(.txt) 파일을 Java 프로그램에서 사용할 수 있도록 변환해주는 처리를 하는 클래스

public class BankStatementTSVParser implements BankStatementParser{

	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	// 한 줄만 파싱하는 기능
	// 이 메서드는 이 클래스에서만 사용할 예정(접근 제한, private)
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split("\t"); // tab으로 구분

		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN); // 문자열 -> 날짜 타입(LocalDate)으로 변환
		final double amount = Double.parseDouble(columns[1]); // 문자열 -> double 변환
		final String description = columns[2];

		// 파싱된 개별 값들을 BankTransaction 이라는 클래스로 묶어줌(Wrapping)
		BankTransaction bankTransaction = new BankTransaction(date, amount, description);
		return bankTransaction;

		// 한줄로 작성
//		return new BankTransaction(date, amount, description);
	}

	// 한줄씩 파싱된 데이터를 리스트에 추가
	// 이 메서드는 외부에서 호출 가능하도록
	public List<BankTransaction> parseLinesFrom(List<String> lines) {

		// 전체 입출금 내역 데이터를 가지고 있는 리스트
		// 타입은 단 건 입출금 내역인 BankTransaction을 사용 중
		List<BankTransaction> bankTransactions = new ArrayList<>();

		for (String line : lines) {
			BankTransaction bankTransaction = parseFrom(line);
			bankTransactions.add(bankTransaction); // 리스트의 개별 요소로 추가
			
			// 한줄로 작성
//			bankTransactions.add(parseFromTSV(line));
		}
		
		return bankTransactions;
	}
}