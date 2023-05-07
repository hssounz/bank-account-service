package com.example.bankaccountservice.service;

import com.example.bankaccountservice.dao.BankAccountRepository;
import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.BankAccountMappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMappers bankAccountDTOMappers;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMappers bankAccountDTOMappers) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountDTOMappers = bankAccountDTOMappers;
    }
    @Override
    public List<BankAccountResponseDTO> getBankAccounts() {
        return bankAccountRepository.findAll()
                .stream()
                .map(
                        bankAccountDTOMappers::responseFromBankAccount
                )
                .collect(Collectors.toList());
    }
    @Override
    public BankAccountResponseDTO getBankAccount(String id) {
        return bankAccountDTOMappers.responseFromBankAccount(
                bankAccountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)))
        );
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("Account %s not found", id))
                );
        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setType(bankAccountRequestDTO.getType());
        bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());

        return bankAccountDTOMappers.responseFromBankAccount(
                bankAccountRepository.save(bankAccount)
        );
    }
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountDTOMappers.responseFromBankAccount(
                bankAccountRepository
                        .save(
                                bankAccountDTOMappers.bankAccountFromRequest(bankAccountRequestDTO)
                        )
        );
    }
    @Override
    public Boolean deleteAccount(String id) {
        if (bankAccountRepository.findById(id).isPresent()) {
            bankAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
