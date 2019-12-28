package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;
public class userController {

    user loggedinUser;

    public void signUp(String name, String password, String email, String gender, String dateOfBirth, String country){
          user user1 = new user();

//          check email if found
               while(user.read(name)!=null){
               System.out.print("userName found,please Enter another email");
               Scanner input = new Scanner(System.in);
               name=input.nextLine();

           }
//               setting the privacy info
               System.out.print("please Enter privacy whether private or public");
               Scanner input = new Scanner(System.in);
               String privacy =input.nextLine();

//              create and saving user
               user1.creatUser(name, password, email, gender, dateOfBirth, country,privacy);
               user.save(user1);

               System.out.println("congrats you can Now login to your account");
               System.out.println("if you want to login 1-yes 2-no ");
               if(input.nextInt()==1)
                   logIn();
               else
                   return;

        }


    public user logIn(){
        String name, password;
        Scanner input=new Scanner(System.in);
        System.out.println("enter name");
        name=input.nextLine();
        System.out.println("enter password");
        password=input.nextLine();
//        user loginobj =new user();
        user DBobj;
        DBobj = user.read(name);

        if(DBobj != null ) {
        if(  DBobj.getPassword().equals(password)) {
            System.out.println("user logged in ");
            loggedinUser=DBobj;
            return DBobj;
        }
        else {
            System.out.print("user blocked ");
            return null;
        }
        }
        else
        {System.out.println("wrong email No account with such email"); return null;}
    }

//    public s
    public void search(String userName){
        user SearchResultUser;
        SearchResultUser = user.read(userName);
//        printSearchResult();

        if(SearchResultUser!=null) {
            System.out.println("user "+ SearchResultUser.getName()+ "Found");
            addFriend(SearchResultUser);}
        else{
            System.out.println("user "+ userName +"not Found");
        }
    }

    public void addFriend(user receiver){

//        loggedinUser = logIn();
        if( loggedinUser==null) {

            System.out.println("please login first");
            logIn();
        }

            receiver.addFriendRequest(loggedinUser.getName()+":  sent you a friend request");
            System.out.println("Friend request sent successfully");

    }

    public void checkFriendRequests(){
        if( loggedinUser==null) {

            System.out.println("please login first");
            logIn();
        }
        loggedinUser.getFriendRequests();
        System.out.println("please enter the number of the friend Request you wish to add");
        Scanner in =new Scanner(System.in);
        int friendRequest = in.nextInt();
        String str =loggedinUser.getFriendRequest(friendRequest);
        String[] result = str.split(":");
        String username= result[0];
        user sender=user.read(username);
        loggedinUser.addFriend(sender);
        sender.addFriend(loggedinUser);
        loggedinUser.Friendrequests.remove(friendRequest);
        System.out.println("you "+sender.getName() +" are now friends");

    }

    public void upgradeRegistration(){
        if( loggedinUser==null) {

            System.out.println("please login first");
            logIn();
        }
        Scanner in= new Scanner(System.in);
        System.out.println("please enter the payment method 1-paypal 2-creditcard");
        int paymentMethod=in.nextInt();
        if(paymentMethod==1)
        loggedinUser.addpaymentMethod("paypal");
        else
            loggedinUser.addpaymentMethod("creditcard");

    }

//    public void addFriendRequest(String name){
//////        read(email);
////        addFriendrequest(name+"  sent you a friend request");
////    }
}
