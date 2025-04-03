
//测试
public class Main {
    public static void main(String[] args) {
        Account alice =new Account("A01",1000);
        Account bob =new Account("A02",500);
        try{
            alice.transfer(bob,1300);
            System.out.println("Alice余额："+alice.getBalance());
            System.out.println("Bob余额："+bob.getBalance());

        }catch (Account.InsufficientBalanceException e){
            System.out.println("转账失败："+e.getMessage());
        }
    }
}