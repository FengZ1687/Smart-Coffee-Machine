package com.example.shuai.scmprotoapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MakeCoffeePage extends AppCompatActivity {


    private String coffeeDisplayName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_coffee_page);
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("");
    }

    public void toCustomizeCoffee(View view) {
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        RadioButton large = (RadioButton) findViewById(R.id.radioLarge);
        RadioButton medium = (RadioButton) findViewById(R.id.radioMedium);
        RadioButton small = (RadioButton) findViewById(R.id.radioSmall);
        Intent intent = new Intent(this, CustomizeCoffeePage.class);
        intent.putExtra("coffeeName", coffeeDisplay.getText().toString());
        // if ((large.isChecked() && medium.isChecked() && small.isChecked()) == false) {
        //    Toast.makeText(getApplicationContext(), "Please select your coffee size", Toast.LENGTH_SHORT).show();
   // }

            if(coffeeDisplayName.equals("")){
                Toast.makeText(getApplicationContext(), "Please select both coffee and its size", Toast.LENGTH_SHORT).show();

            }
            else if (large.isChecked() ) {
                intent.putExtra("coffeeSize", "large");
                startActivity(intent);
            }
            else if (medium.isChecked()) {
                intent.putExtra("coffeeSize", "medium");
                startActivity(intent);
            }
            else if (small.isChecked()) {
                intent.putExtra("coffeeSize", "small");
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(), "Please select both coffee and its size", Toast.LENGTH_SHORT).show();
            }
            }






    public void toPayment(View view){
        Intent intent = new Intent(this, PaymentPage.class);
        startActivity(intent);
    }


    public void mochaClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Mocha");
        coffeeDisplayName = "Mocha";
        Toast.makeText(getApplicationContext(),"Mocha Selected",Toast.LENGTH_SHORT).show();

    }

    public void expressoClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Expresso");
        coffeeDisplayName = "Expresso";
        Toast.makeText(getApplicationContext(),"Expresso Selected",Toast.LENGTH_SHORT).show();

    }

    public void turkishClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Turkish");
        coffeeDisplayName = "Turkish";
        Toast.makeText(getApplicationContext(),"Turkish Selected",Toast.LENGTH_SHORT).show();
    }

    public void americanoClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Americano");
        coffeeDisplayName = "Americano";
        Toast.makeText(getApplicationContext(),"Americano Selected",Toast.LENGTH_SHORT).show();

    }

    public void cappuClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Cappuccino");
        coffeeDisplayName = "Cappuccino";
        Toast.makeText(getApplicationContext(),"Cappuccino Selected",Toast.LENGTH_SHORT).show();

    }

    public void latteClick(View view){
        TextView coffeeDisplay = (TextView) findViewById(R.id.coffeeSelected);
        coffeeDisplay.setText("Latte");
        coffeeDisplayName = "Latte";
        Toast.makeText(getApplicationContext(),"Latte Selected",Toast.LENGTH_SHORT).show();


    }

    public void radioLargeClicked(View view){
        RadioButton large = (RadioButton) findViewById(R.id.radioLarge);
        RadioButton medium = (RadioButton) findViewById(R.id.radioMedium);
        RadioButton small = (RadioButton) findViewById(R.id.radioSmall);
        if(large.isChecked() && (medium.isChecked() || small.isChecked())){
            medium.setChecked(false);
            small.setChecked(false);
        }
    }

    public void radioMediumClicked(View view){
        RadioButton large = (RadioButton) findViewById(R.id.radioLarge);
        RadioButton medium = (RadioButton) findViewById(R.id.radioMedium);
        RadioButton small = (RadioButton) findViewById(R.id.radioSmall);
        if(medium.isChecked() && (large.isChecked() || small.isChecked())){
            large.setChecked(false);
            small.setChecked(false);
        }

    }

    public void radioSmallClicked(View view){
        RadioButton large = (RadioButton) findViewById(R.id.radioLarge);
        RadioButton medium = (RadioButton) findViewById(R.id.radioMedium);
        RadioButton small = (RadioButton) findViewById(R.id.radioSmall);
        if(small.isChecked() && (large.isChecked()|| medium.isChecked())){
            large.setChecked(false);
            medium.setChecked(false);
        }

    }

}
