import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Account;
import entities.Bank;
import entities.Client;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        boolean exit = false;
        boolean bankChoice = false;

        System.out.println(
                "Este App é um desafio de código para a plataforma DIO.É uma espécie de playground que imita as operações de um banco,                 onde podemos criar, selecionar e deletar as contas.%n%n");

        while (bankChoice == false) {
            System.out.println("Digite o número do banco e tecle ENTER:");
            System.out.println("1 - Banco GNU do povo");
            System.out.println("2 - Banco Git status");
            try {
                int numeroBanco = sc.nextInt();

                switch (numeroBanco) {
                    case 1:
                        bank.setName("GNU");
                        bankChoice = true;
                        break;
                    case 2:
                        bank.setName("Git");
                        bankChoice = true;
                        break;
                    default:
                        System.out.println("Digite um número válido.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Insira um número inteiro de acordo com o banco. ");
            } catch (Exception e) {
                System.out.println("Erro ao tentar selecionar banco.");
            }
        }

        while (exit != true) {
            System.out.println("");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Visualizar conta e suas operações");
            System.out.println("3 - Cancelar conta");
            System.out.println("4 - Sair do sistema");
            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        createNewAccount(bank);
                        break;
                    case 2:
                        selectAccount(bank);
                        break;
                    case 3:
                        removeAccount(bank);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Digite um número válido.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro válido de acordo com as opções.");
            } catch (Exception e) {
                System.out.println("Um erro acorreu durante a escolha das opções. Tente novamente.");
            }
        }

        sc.close();
    }

    private static void removeAccount(Bank bank) {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Contas existentes:");
        List<Account> accounts = bank.getAccounts();

        if (accounts.size() >= 1) {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.printf("%d - %s %n", accounts.get(i).getNumber(), accounts.get(i).getHouder().getName());
            }
        } else {
            System.out.println("Aviso: Não há contas cadastradas.");
        }

        System.out.println("");
        System.out.println("Digite o número da conta a ser removida:");

        try {
            int accNumber = sc.nextInt();

            if (accounts.removeIf(acc -> acc.getNumber() == accNumber)) {
                System.out.printf("Conta %d removida com sucesso.", accNumber);
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite um número válido.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentarmos remover a conta." + e.getMessage());
        }

        sc.close();
    }

    private static void selectAccount(Bank bank) {
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("Contas existentes:");
        List<Account> accounts = bank.getAccounts();

        if (accounts.size() >= 1) {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.printf("%d - %s %n", accounts.get(i).getNumber(), accounts.get(i).getHouder().getName());
            }
        } else {
            System.out.println("Aviso: Não há contas cadastradas.");
        }

        try {
            System.out.println("");
            System.out.println("Digite o número da conta:");
            int accNumber = sc.nextInt();

            Account account = bank.getAccountByNumber(accNumber);

            if (account != null) {
                System.out.println("");
                account.toString();
                System.out.println("");

                operateAccount(account);
            } else {
                System.out.printf("Conta %d não encontrada", accNumber);
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite um número válido." + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro na tentativa de visualizar e operar a conta." + e.getMessage());
        }

        sc.close();
    }

    private static void operateAccount(Account account) {
        Scanner sc = new Scanner(System.in);
        boolean toBack = false;

        while (toBack != true) {
            System.out.println("Selecione a operação que deseja realizar:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Saque");
            System.out.println("3 - Depósito");
            System.out.println("4 - Transferência");
            System.out.println("5 - Voltar");

            try {
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        account.showBalance();
                        break;
                    case 2:
                        operateWithdraw(account);
                        break;
                    case 3:
                        operateDeposit(account);
                        break;
                    case 4:
                        operateTransfer(account);
                        break;
                    case 5:
                        System.out.println("Voltando...");
                        break;
                    default :
                        System.out.println("");
                        System.out.println("Digite uma opção válida.");
                        System.out.println("");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida.");
            } catch (Exception e) {
                System.out.println("Erro ao trabalhar com as operações da conta. " + e.getMessage());
            }
        }

        sc.close();
    }

    private static void createNewAccount(Bank bank) {

    }
}
