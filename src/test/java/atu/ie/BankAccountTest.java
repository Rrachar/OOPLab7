package atu.ie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }
    void constructorInitialisation() {

        account = new BankAccount("ACC12345", "Paul",  100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Paul",account.getName());
        assertEquals(100,account.getBalance());
    }


    @Test
    public void constructorNegativeInitialisation()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Paul", -100));
        assertEquals("Balance must be greater than 0.", ex.getMessage());

    }
    @Test
    public void DepositPositiveTest()
    {
        account = new BankAccount("ACC12345", "Paul",  100);
        account.deposit(100);
        assertEquals(200,account.getBalance());
    }

    @Test
    public void depositNegativeTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-1));
        assertEquals("Deposit amount must be greater than 0.", ex.getMessage());

    }

    @Test
    public void WithdrawPositiveTest()
    {
        account = new BankAccount("ACC12345", "Paul",  100);
        account.withdraw(100);
        assertEquals(0,account.getBalance());
    }

    @Test
    public void withdrawNegativeTest()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1));
        assertEquals("Withdraw amount must be greater than 0.", ex.getMessage());
    }

    @Test
    public void WithdrawOverBalanceTest()
    {
       account = new BankAccount("ACC12345", "Paul",  100);
       Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
       assertEquals("Not enough funds to withdraw that amount.", ex.getMessage());



    }
}
