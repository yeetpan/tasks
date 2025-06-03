import java.util.Scanner;
class Account {
    private String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Class for Transaction
class Transaction {
    private String transactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;

    public Transaction(String transactionId, Account sourceAccount, Account destinationAccount, double amount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public double getAmount() {
        return amount;
    }
}

// Custom Exception for Transactions
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}


public class TransactionProcessor {
    public static void processTransaction(Transaction transaction) throws TransactionException {
        final double TRANSACTION_LIMIT = 1000.0;

        Account source = transaction.getSourceAccount();
        Account destination = transaction.getDestinationAccount();
        double amount = transaction.getAmount();

        if (amount > TRANSACTION_LIMIT) {
            throw new TransactionException("Transaction amount exceeds the limit.");
        }

        if (source.getBalance() < amount) {
            throw new TransactionException("Insufficient balance in source account.");
        }

        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
    }

    // Non editable starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sourceAccountId = scanner.nextLine();
        double sourceAccountBalance = Double.parseDouble(scanner.nextLine());
        String destinationAccountId = scanner.nextLine();
        double destinationAccountBalance = Double.parseDouble(scanner.nextLine());

        String transactionId = scanner.nextLine();
        double transactionAmount = Double.parseDouble(scanner.nextLine());

        try {
            Account sourceAccount = new Account(sourceAccountId, sourceAccountBalance);
            Account destinationAccount = new Account(destinationAccountId, destinationAccountBalance);
            Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount, transactionAmount);

            processTransaction(transaction);

            System.out.println("Transaction successful!");
        } catch (TransactionException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    // Non editable ends here
}

