package com.company;
import java.util.ArrayList;
public class user {


    public static ArrayList<user> users = new ArrayList<>();
    String name;
    String password;
    String email;
    String gender;
    String dateOfBirth;
    String country;
    String privacy;
    String paymentMethod=" ";
    Boolean notify;
    ArrayList<String> Friendrequests=new ArrayList<>();
    ArrayList<user> friends=new ArrayList<>();

    public void creatUser(String name, String password, String email, String gender, String dateOfBirth, String country,String privacy) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.privacy= privacy;
    }

//    public String getEmail() { return email; }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public void addpaymentMethod(String paymentMethod){this.paymentMethod=paymentMethod;}

    public static void save(user u) {users.add(u);}

    public void addFriendRequest(String request) {Friendrequests.add(request);}

    public static user read(String name) {
        for (int i = 0; i < user.users.size(); i++) {
            if (users.get(i).getName().equals( name)) {
                return users.get(i);
            }
        }return null;
    }


    public  void getFriendRequests() {
        for (int i = 0; i < Friendrequests.size(); i++) {
            System.out.println(i+" "+Friendrequests.get(i));
        }
    }

    public void addFriend(user user1) {

        friends.add(user1);
    }
    public String getFriendRequest(int noFriendRequest) {

          return Friendrequests.get(noFriendRequest);
    }

//    public user read(String email,String password) {
//        for (int i = 0; i < user.users.size(); i++) {
//            if (users.get(i).getEmail() == email ) {
//                return users.get(i);
//            }
//        }return null;
//    }
}
