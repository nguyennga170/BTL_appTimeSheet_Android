package com.example.btl;

import java.util.ArrayList;

public class UserRepo {
    private static ArrayList<User> userRepo = new ArrayList<>();

    public static ArrayList<User> getUserRepo() {
        return userRepo;
    }

    public static void setUserRepo(ArrayList<User> userRepo) {
        UserRepo.userRepo = userRepo;
    }
    public static void addUser(User u){
        userRepo.add(u);
    }
    public static void removeUser(User u){
        userRepo.remove(u);
    }
    public static boolean checkUser(User user){
        int t=0;
        for(User u: userRepo){
            if(user.getEmail().equals(u.getEmail())&&user.getPasword().equals(u.getPasword()))
                t++;
        }
        if (t>1)
            return true;
        return false;
    }
}