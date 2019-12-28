package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//        public static user model = new user();
        //public static ArrayList<user> users = new ArrayList<>();
            int choice;
            user user1 = new user();
            user user2 = new user();
            user user3 = new user();
            user1.creatUser("Aya", "123", "@gmail", "female", "2000", "egypt","public");
            user1.addFriendRequest("ola:  sent you a friend request");
            user1.addFriendRequest("Thoria:  sent you a friend request");
            user.save(user1);

            user2.creatUser("Thoria", "156", "1@gmail", "female", "2000", "egypt","public");
            user.save(user2);

            user3.creatUser("ola", "1323", "2@gmail", "female", "2000", "egypt","public");
            user.save(user3);
//            user.users.add(model);

         userController c=new userController();
         printChoices();
         Scanner input=new Scanner(System.in);
         choice= input.nextInt();
         if(choice == 1) {
             c.signUp("Aya", "123", "@14gmail", "female", "2000", "egypt");

         }
         else if(choice == 2){
             c.logIn();
             System.out.println("what do you wish to do 3-search for friends 4-check friend requests 5-upgrade registration");
             Scanner in=new Scanner(System.in);
             choice= in.nextInt();
         }
         if(choice == 3){
             Scanner in=new Scanner(System.in);
             String userName;
             System.out.println("enter the user name to search for");
             userName = in.nextLine();
             c.search(userName);


         }
         if(choice == 4){
             c.checkFriendRequests();
         }
        if(choice == 5){
            c.upgradeRegistration();
        }
        else return;
        }

        public static void printChoices(){
            System.out.println("please Enter a choice   1-sign up  2-login 3-search for friends ");
        }
    }

