package com.example.shuai.scmprotoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccountPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        TextView resultText = (TextView) findViewById(R.id.balanceText);
        resultText.setText(String.format("%s", ((GlobalVars) this.getApplication()).getBalance()));
    }

    public void toChargePage(View view){
        Intent intent = new Intent(this, ChargeBalancePage.class);
        startActivity(intent);
    }

    public void toContentPage(View view){
        Intent intent = new Intent(this, ContentPage1.class);
        startActivity(intent);
    }


}
