package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account account = new Account(100);
        account.deposit(50);
        assertThat(account.balance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        Account account = new Account(100);
        account.withdraw(50);
        assertThat(account.balance(), is(50));
    }

    @Test
    @Ignore  // Remove each @Ignore and implement test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){

    }
}
