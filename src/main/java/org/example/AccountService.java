package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;

@ApplicationScoped
public class AccountService {

    public Account getAccountById(Long accountId) {
        return Account.findById(accountId);
    }

    public BigDecimal getAccountBalance(Long accountId) {
        Account account = Account.findById(accountId);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        return account.balance;
    }

    @Transactional
    public Account updateAccountBalance(Long accountId, BigDecimal newBalance) {
        Account account = Account.findById(accountId);
        if (account == null) {
            throw new RuntimeException("Account not found");
        }
        account.balance = newBalance;
        return account;
    }

    public boolean validateAccount(Long accountId) {
        return Account.findById(accountId) != null;
    }

    @Transactional
    public Account addAccount(Account account) {
        account.persist();
        return account;
    }
}
