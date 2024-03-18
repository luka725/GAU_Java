public class BankAccount {
    public String OwnerName;
    public String OwnerLastname;
    public String AccountId;
    private float Money;
    public BankAccount(String name, String last_name, String id){
        this.OwnerName = name;
        this.OwnerLastname = last_name;
        this.AccountId = id;
    }
    public void AddMoney(float amount){
        Money += amount;
    }
    public void WithdrawMoney(float amount){
        if(Money - amount < 0){
            System.out.println("Not enough money in the account!");
        }
        else{
            Money -= amount;
        }
    }
    public float Deposit(float amount, int month){
        return amount * month / 100;
    }
    public float GetMoney(){
        return Money;
    }
}