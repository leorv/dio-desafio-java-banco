package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts = new ArrayList<>();


    public Bank() {
    }

    public Bank(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }    

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * 
     * @param number
     * @return Account, null
     */
    public Account getAccountByNumber(int number) {
        Iterator<Account> iterator = accounts.iterator();
        while(iterator.hasNext()) {
            Account acc = iterator.next();

            if (acc.getNumber() == number) return acc;
        }
        return null;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(int accIndex) {
        accounts.remove(accIndex);
    }

}
