package MachineTest;
import java.util.*;
public class Customer {
	
	//Variables
    long AccountNo;
    String name;
    String AccountType;
    float balance;
    float MinBalance=1000.0f;
    long MobileNo;
    String EmailId;
    int pin;
    //Scanner class
    Scanner scanner = new Scanner(System.in);

    //Customer Registration
     Customer(){
         System.out.println("Enter your name:");
         this.name=scanner.nextLine();
         this.AccountNo=generateAccountNumber();
         System.out.println("Your account no:"+this.AccountNo);

         this.pin=generatePin();
         System.out.println("Your PIN is:"+this.pin);

        System.out.println("Enter your account type:(Saving/Current)");
         this.AccountType=scanner.next();


         while(true){
             Next:
             System.out.println("Enter your Initial balance:");
             this.balance=scanner.nextFloat();
             if(this.balance>1000)
                break;
             else
                 System.out.println("Please enter amount greater then 1000.");
         }


        System.out.println("Enter your mobile No:");
         this.MobileNo=scanner.nextLong();
        System.out.println("Enter your e-mail id:");
         this.EmailId=scanner.next();


    }
     
     //Update Customer Details
    void updateDetail(){
        System.out.println("Enter your new Mobile no:");
        this.MobileNo=scanner.nextLong();
        System.out.println("Enter your new email ID:");
        this.EmailId=scanner.next();


    }
    
    //Deposit Money

    void deposit(){
        long amount;
        System.out.println("Enter the amount to deposit:");
        amount=scanner.nextLong();
        if(amount>50000){
            System.out.println("Enter your PAN card no:");
            String pan=scanner.next();
        }
        this.balance += amount;

    }
    //Update Mobile Number
    void setMobileNo(){
        System.out.println("Enter your new mobile no:");
        this.MobileNo=scanner.nextLong();
    }
    
    //Update Email
    void setEmailId(){
        System.out.println("Enter your new email id:");
        this.EmailId=scanner.next();
    }

    @Override
    public String toString(){
         return "Account no:"+this.AccountNo+"\n"+" Name:"+this.name+"\n"+" Account type:"+this.AccountType +
        		 "\n"+  " Balance:"+this.balance+"\n"+" Mobile No:" +this.MobileNo+"\n"+" Email-id:"+this.EmailId+"\n";
    }
    @Override
    public boolean equals(Object obj){
         Customer that=(Customer) obj;
         return this.AccountNo==that.AccountNo;
    }
    
    //Random Account No
    int generateAccountNumber(){
         int accountNo=(int)Math.floor(Math.random()*1000000000);
         return accountNo;
    }
    
    //Random Pin
    int generatePin(){
         int pin=(int)Math.floor(Math.random()*10000);
            return pin;
    }

}
