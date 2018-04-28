package com.example.shuai.scmprotoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChargeBalancePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_balance_page);
    }

    public void addFive(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to add $5?");
        // alert.setMessage("Message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                addBalance(5.0);
                Toast.makeText(getApplicationContext(),"Balance of $5 added successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();


    }

    public void addTen(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to add $10?");
        // alert.setMessage("Message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                addBalance(10.0);
                Toast.makeText(getApplicationContext(),"Balance of $10 added successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void addTwenty(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to add $20?");
        // alert.setMessage("Message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                addBalance(20.0);
                Toast.makeText(getApplicationContext(),"Balance of $20 added successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void addFifty (View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to add $50?");
        // alert.setMessage("Message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                addBalance(50.0);
                Toast.makeText(getApplicationContext(),"Balance of $50 added successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void addHundred(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure to add $100?");
        // alert.setMessage("Message");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                addBalance(100.0);
                Toast.makeText(getApplicationContext(),"Balance of $100 added successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void toAccount(View view){
        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
    }



    public void addBalance(double balance){
        ((GlobalVars)this.getApplication()).addBalance(balance);
    }
}
