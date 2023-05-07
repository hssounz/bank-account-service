package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;

public interface BankAccountMappers {
    public BankAccountResponseDTO responseFromBankAccount(BankAccount bankAccount);
    public BankAccountRequestDTO requestFromBankAccount(BankAccount bankAccount);
    public BankAccount bankAccountFromRequest(BankAccountRequestDTO bankAccountRequestDTO);
}
