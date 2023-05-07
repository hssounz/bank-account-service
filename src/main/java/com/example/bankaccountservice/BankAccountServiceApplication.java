package com.example.bankaccountservice;

import com.example.bankaccountservice.dao.BankAccountRepository;
import com.example.bankaccountservice.dao.CustomerRepository;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Hassen", "Yassine", "Hana", "Imen").forEach(
					name -> {
						customerRepository.save(
								Customer.builder()
										.name(name)
										.build()
						);
					}
			);
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.balance(100 + Math.random()*1400)
							.type(Math.random() < 0.5 ? AccountType.SAVINGS_ACCOUNT : AccountType.CURRENT_ACCOUNT)
							.currency(Math.random() < 0.5 ? "EUR" : "USD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});
		};
	}

}
