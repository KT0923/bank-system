public class Account {
    private String accountID;
    private double balance;

    public Account(String accountID, double initialBalance) {
        this.accountID = accountID;
        if (initialBalance < 0) throw new IllegalArgumentException("初始余额不能为负");
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("存款金额必须大于0");
        //这行代码的作用是 主动抛出一个异常，用于在程序中检测到不合法的参数时终止执行，并提示错误信息。
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) throw new InsufficientBalanceException("余额不足！");
        //这行代码的作用是 主动抛出一个异常，用于在程序中检测到不合法的参数时终止执行，并提示错误信息。
        balance += amount;
    }

    public void transfer(Account target, double amount) throws InsufficientBalanceException {
        this.withdraw(amount);
        target.deposit(amount);
    }
    public String getAccountID(){return accountID;}
    public double getBalance(){return balance;}


    /*
    在银行账户系统中，当用户尝试 取款或转账超过账户余额时，需要让程序识别这个错误，并阻止非法操作。
    而InsufficientBalanceException 就是专门用来处理这种情况的业务逻辑异常。
     */
    class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }


}
