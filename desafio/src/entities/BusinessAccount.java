package entities;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, Client houder, Double balance, Double loanLimit) {
        super(number, houder, balance);
        this.loanLimit = loanLimit;
    }

    /**
     * @return Double return the loanLimit
     */
    public Double getLoanLimit() {
        return loanLimit;
    }

    /**
     * @param loanLimit the loanLimit to set
     */
    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    /**
     * Este método é {@code final} para evitarmos sobreposições múltiplas, que são portas
     * de entrada para inconsistências.
     */
    @Override
    public final void withdraw(Double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }

    @Override
    public final void transfer(Double amount, Account account) {
        this.withdraw(amount + 7.90);
        account.deposit(amount);
    }

}
