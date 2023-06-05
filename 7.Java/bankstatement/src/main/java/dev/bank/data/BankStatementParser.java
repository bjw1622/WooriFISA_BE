package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

public interface BankStatementParser {
	// 메서드명 추상화 (parseFromTSV, CSV -> parseFrom)
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}