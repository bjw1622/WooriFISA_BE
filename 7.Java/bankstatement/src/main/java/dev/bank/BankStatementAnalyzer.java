package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/";

	public void analyze(String fileName, BankStatementParser parser) throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		List<String> lines = Files.readAllLines(path);

		List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);
		
		final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(processor);
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은 " + processor.calculateTotalAmount() + "입니다.");
		
		System.out.println("2월의 총 입출금액은" + processor.calculateTotalInMonth(Month.FEBRUARY) + "입니다");
	}
	
}
