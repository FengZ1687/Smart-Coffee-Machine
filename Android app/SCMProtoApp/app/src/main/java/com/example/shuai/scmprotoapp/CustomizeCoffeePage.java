package com.example.shuai.scmprotoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CustomizeCoffeePage extends AppCompatActivity {


    private double sugarValue = 0;
    private double creamValue = 0;
    private double chocoValue = 0;
    private double milkValue = 0;
    private double priceTotal = 0;
    private String coffeeSize = "";
    private String coffeeSelected = "";  //value will be passed from MakeCoffeePage


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_coffee_page);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            coffeeSelected = extras.getString("coffeeName");
            coffeeSize = extras.getString("coffeeSize");

        }
        TextView resultText = (TextView) findViewById(R.id.coffeeType);
        resultText.setText(coffeeSelected + "(" + coffeeSize +")");

    }

    public void toPayment(View view){
        CheckBox sugar = (CheckBox) findViewById(R.id.sugarCheck);
        CheckBox cream = (CheckBox) findViewById(R.id.creamCheck);
        CheckBox choco = (CheckBox) findViewById(R.id.chocoCheck);
        CheckBox milk = (CheckBox) findViewById(R.id.milkCheck);
        CheckBox decaf = (CheckBox) findViewById(R.id.decafCheck);


        Intent intent = new Intent(this, PaymentPage.class);
        if(sugar.isChecked()){
            intent.putExtra("sugarValue", sugarValue);
        }else{
            intent.putExtra("sugarValue", 0);
        }
        if(cream.isChecked()){
            intent.putExtra("creamValue", creamValue);
        }else{
            intent.putExtra("creamValue", 0);
        }
        if(choco.isChecked()){
            intent.putExtra("chocoValue", chocoValue);
        }else{
            intent.putExtra("chocoValue", 0);
        }
        if (milk.isChecked()) {

            intent.putExtra("milkValue", milkValue);
        }else{
            intent.putExtra("milkValue", 0);
        }
        if(decaf.isChecked()){
            intent.putExtra("isDecaf", true);
        }else{
            intent.putExtra("isDecaf", false);
        }
        intent.putExtra("coffeeSize", coffeeSize);
        intent.putExtra("coffeeName", coffeeSelected);
        intent.putExtra("coffeePrice", priceTotal);
        startActivity(intent);
    }

    public void sugarAdd(View view){
        TextView resultText = (TextView) findViewById(R.id.sugarResult);
        sugarValue = sugarValue+0.5;
       // String outputTmp = Double.toString(sugarValue);
        resultText.setText(String.format("%s g", sugarValue));
    }

    public void sugarMinus(View view){
        TextView resultText = (TextView) findViewById(R.id.sugarResult);
        if(sugarValue <=0){
            Toast.makeText(getApplicationContext(),"Value cannot be less than zero!",Toast.LENGTH_SHORT).show();
        }else {
            sugarValue = sugarValue - 0.5;

            resultText.setText(String.format("%s g", sugarValue));
        }
    }
    public void creamAdd(View view) {
        TextView resultText = (TextView) findViewById(R.id.creamResult);
       creamValue = creamValue + 0.5;
       resultText.setText(String.format("%s g", creamValue));
    }

    public void creamMinus(View view) {
        TextView resultText = (TextView) findViewById(R.id.creamResult);
        if(creamValue<=0){
            Toast.makeText(getApplicationContext(),"Value cannot be less than zero!",Toast.LENGTH_SHORT).show();
        }else{
            creamValue = creamValue-0.5;
            resultText.setText(String.format("%s g", creamValue));
        }
    }

    public void chocoAdd(View view) {
        TextView resultText = (TextView) findViewById(R.id.chocoResult);
        chocoValue = chocoValue+0.5;
        resultText.setText(String.format("%s g", chocoValue));
    }

    public void chocoMinus(View view) {
        TextView resultText = (TextView) findViewById(R.id.chocoResult);
        if(chocoValue<=0){
            Toast.makeText(getApplicationContext(),"Value cannot be less than zero!",Toast.LENGTH_SHORT).show();
        }else{
            chocoValue = chocoValue-0.5;
            resultText.setText(String.format("%s g", creamValue));
        }
    }

    public void milkAdd(View view) {
        TextView resultText = (TextView) findViewById(R.id.milkResult);
        milkValue = milkValue+0.5;
        resultText.setText(String.format("%s g", milkValue));
    }

    public void milkMinus(View view) {
        TextView resultText = (TextView) findViewById(R.id.milkResult);
        if(milkValue<=0){
            Toast.makeText(getApplicationContext(),"Value cannot be less than zero!",Toast.LENGTH_SHORT).show();
        }else{
            milkValue = milkValue-0.5;
            resultText.setText(String.format("%s g", milkValue));
        }
    }

    public void clearValue(View view){
        sugarValue =0;
        creamValue =0;
        chocoValue =0;
        milkValue =0;
        TextView tmp1 = (TextView) findViewById(R.id.milkResult);
        TextView tmp2 = (TextView) findViewById(R.id.chocoResult);
        TextView tmp3 = (TextView) findViewById(R.id.creamResult);
        TextView tmp4 = (TextView) findViewById(R.id.sugarResult);
        tmp1.setText("");
        tmp2.setText("");
        tmp3.setText("");
        tmp4.setText("");
    }
}
