package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMappersImpl implements BankAccountMappers {
    @Override
    public BankAccountResponseDTO responseFromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder().build();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountRequestDTO requestFromBankAccount(BankAccount bankAccount) {
        BankAccountRequestDTO bankAccountRequestDTO = BankAccountRequestDTO.builder().build();
        BeanUtils.copyProperties(bankAccount, bankAccountRequestDTO);
        return bankAccountRequestDTO;
    }

    @Override
    public BankAccount bankAccountFromRequest(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder().build();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
