package atu.ie;

public class BankAccount {
      private String accNo;
      private String name;
      private double balance;

    public BankAccount() {
    }

    public BankAccount(String accNo, String name, double balance)
      {
          if(balance < 0)
          {
              throw new IllegalArgumentException("Balance must be greater than 0.");
          }
          this.accNo = accNo;
          this.name = name;
          this.balance = balance;



      }


    public String getAccNo() {
          return accNo;
    }

    public String getName() {
          return name;
    }
    public double getBalance() {
          return balance;
    }

    public void deposit(int depositAmount) {
        if (depositAmount <= 0)
        {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }
        this.balance += depositAmount;
    }

    public void withdraw(int withdrawAmount) {
        if (withdrawAmount <= 0)
            {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0.");
            }
        this.balance -= withdrawAmount;
    }
}
