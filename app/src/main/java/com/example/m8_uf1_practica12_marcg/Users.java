package com.example.m8_uf1_practica12_marcg;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {
    private String userName;
    private int Tries;

    public Users(String userName, int Tries){
        this.userName = userName;
        this.Tries = Tries;

    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public int getTries(){
        return Tries;
    }

    public void setTries(int Tries){

        this.Tries = Tries;
    }

    public String toString(){
        return "Username: " + userName + ", Tries: " + Tries;
    }
}
