package com.example.bankaccountservice.service;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.enums.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BankAccountService {
    public List<BankAccountResponseDTO> getBankAccounts();
    public BankAccountResponseDTO getBankAccount(String id);
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public Boolean deleteAccount(String id);
}
