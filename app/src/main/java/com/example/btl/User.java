package com.example.btl;

public class User {
    private String email;
    private String pasword;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public User(String email, String pasword) {
        this.email = email;
        this.pasword = pasword;
    }

    public String getPasword() {
        return pasword;
    }
    public boolean checkEmail(){
        if (this.getEmail().length()>=6&&this.getEmail().contains("@gmail.com")){
            return true;
        }
        return false;
    }
    public boolean checkPassword(){
        if (this.getPasword().length()>=6){
            return true;
        }
        return false;
    }
    public boolean checkValidUser(){
        User user = new User(email,pasword);
        UserRepo userRepo = new UserRepo();
        UserRepo.addUser(user);
        if (userRepo.checkUser(user)){
            userRepo.removeUser(user);
            return true;
        }
        else {
            userRepo.removeUser(user);
            return false;
        }

    }
}
