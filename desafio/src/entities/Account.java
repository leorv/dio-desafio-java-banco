package entities;

public class Account {
    private Integer number;
    private Client houder;
    protected Double balance;

    public Account() {
    }

    public Account(Integer number, Client houder, Double balance) {
        this.number = number;
        this.houder = houder;
        this.balance = balance;
    }

    /**
     * @return Integer return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return String return the houder
     */
    public Client getHouder() {
        return houder;
    }

    /**
     * @param houder the houder to set
     */
    public void setHouder(Client houder) {
        this.houder = houder;
    }

    /**
     * @return Double return the balance
     */
    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double amount) {
        balance -= amount + 5.0;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void transfer(Double amount, Account account) {
        this.withdraw(amount);
        account.deposit(amount);
    }


    @Override
    public String toString() {
        return "{" +
            "%n  número da conta:'" + getNumber() + "'" +
            ",%n  cliente:'" + getHouder() + "'" +
            "}";
    }

    public String showBalance() {
        return "Saldo da conta: R$" + String.format("%.2f", getBalance());
    }


}
