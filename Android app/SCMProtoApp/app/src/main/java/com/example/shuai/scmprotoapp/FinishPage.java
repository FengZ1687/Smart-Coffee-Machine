package com.example.shuai.scmprotoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FinishPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_page);
    }

    public void toContent(View view){
        Intent intent = new Intent(this, ContentPage1.class);
        startActivity(intent);


    }
}
