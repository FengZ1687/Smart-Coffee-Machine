package com.example.shuai.scmprotoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ContentPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page1);



    }

    public void toAccount(View view){

        Intent intent = new Intent(this, AccountPage.class);
        startActivity(intent);
    }

    public void toMakeCoffee(View view){

        Intent intent = new Intent(this, MakeCoffeePage.class);
        startActivity(intent);
    }


}
