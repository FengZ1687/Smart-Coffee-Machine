package com.example.shuai.scmprotoapp;

import android.app.Application;

public class GlobalVars extends Application {
    private double balance = 0.0;
    private boolean sufficient = true;


    public double getBalance(){
        return balance;
    }

    public void addBalance(double balance){
        this.balance += balance;
    }

    public boolean chargeBalance(double balance){
        if(this.balance>= balance) {
            this.balance -= balance;
            sufficient = true;
            return sufficient;
        }else{
            sufficient = false;
            return sufficient;
        }
    }

    public boolean checkSufficient(){
        return sufficient;
    }
}
