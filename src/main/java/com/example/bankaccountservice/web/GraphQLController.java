package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.service.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {
    private final BankAccountService bankAccountService;

    public GraphQLController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @QueryMapping
    public List<BankAccountResponseDTO> bankAccountsList() {
        return bankAccountService.getBankAccounts();
    }
    @QueryMapping
    public BankAccountResponseDTO bankAccountById(@Argument String id) {
        return bankAccountService.getBankAccount(id);
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument("inputBankAccount") BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.addAccount(bankAccountRequestDTO);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument("inputBankAccount") BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.updateAccount(id, bankAccountRequestDTO);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        return bankAccountService.deleteAccount(id);
    }
}
