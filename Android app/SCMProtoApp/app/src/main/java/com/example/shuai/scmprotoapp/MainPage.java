package com.example.shuai.scmprotoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nispok.snackbar.Snackbar;


public class MainPage extends AppCompatActivity  {

    protected CharSequence text = "Username or password cannot be empty";
    protected CharSequence text2 = "Username or password is wrong";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        Button button1 = (Button)findViewById(R.id.button1);



    }

    public void redirect1(View view){
      EditText usrname = (EditText)findViewById(R.id.usrname);
        EditText passwrd = (EditText)findViewById(R.id.passwrd);

        if(usrname.getText().toString().equals("")|| passwrd.getText().toString().equals("")){              //Authentication to be implemented


            Toast.makeText(getApplicationContext(), "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
       }else{
            Intent intent = new Intent(MainPage.this, ContentPage1.class);
            startActivity(intent);
       }
    }


}
