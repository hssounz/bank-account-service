package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data @Builder
public class BankAccountResponseDTO {
    private String id;
    private LocalDateTime createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
