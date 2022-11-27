package entities;

/**
 * A classe SavingsAccount não pode ser herdada por nenhuma outra. Não posso,
 * pode exemplo, criar uma classe SavingsAccountPlus.
 */
public final class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, Client houder, Double balance, Double interestRate) {
        super(number, houder, balance);
        this.interestRate = interestRate;
    }

    /**
     * @return Double return the interestRate
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(Double amount) {
        balance -= amount;
    }

}
