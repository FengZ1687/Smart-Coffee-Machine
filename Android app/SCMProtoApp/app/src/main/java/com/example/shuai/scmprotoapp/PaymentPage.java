package com.example.shuai.scmprotoapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class PaymentPage extends AppCompatActivity {

    private String coffeeName = "";
    private String coffeeSize = "";
    private double sugarValue = 0;
    private double creamValue = 0;
    private double chocoValue = 0;
    private double milkValue = 0;
    private double priceTotal = 0;
    private boolean isDecaf = false;
    private String decafDisplay = "";
    private String orderInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            sugarValue = extras.getDouble("sugarValue");
            creamValue = extras.getDouble("creamValue");
            chocoValue = extras.getDouble("chocoValue");
            milkValue = extras.getDouble("milkValue");
            isDecaf = extras.getBoolean("isDecaf");
            coffeeName = extras.getString("coffeeName");
            coffeeSize = extras.getString("coffeeSize");
            if(coffeeSize.equalsIgnoreCase("small")){
                priceTotal = 1.99;
            }else if(coffeeSize.equalsIgnoreCase("medium")){
                priceTotal = 2.69;
            }else{
                priceTotal = 3.49;
            }
        }
        if(isDecaf){
            decafDisplay = "YES";
        }else{
            decafDisplay = "NO";
        }

        TextView resultText = (TextView) findViewById(R.id.coffeeName);
        resultText.setText(coffeeName + " ("+ coffeeSize + ")");
        TextView resultText2 = (TextView) findViewById(R.id.ingradients);
        resultText2.setText("Sugar: "+ sugarValue + " g \n" + "Cream: "+ creamValue +" g \n" + "Chocolate: " + chocoValue + " g \n" + "Milk: " + milkValue + " g \n" + "Decaf: " + decafDisplay);
        TextView resultText3 = (TextView)findViewById(R.id.priceAmount);
        resultText3.setText(String.format("%s", "$ "+ priceTotal));



    }


    protected void commandGeneration(){
      if(coffeeSize.equals("small")){
          orderInfo = "0 " + sugarValue + " 70 °C";
      }else if(coffeeSize.equals("medium")){
          orderInfo = "1 " + sugarValue + " 70 °C";
        }else if(coffeeSize.equals("large")){
          orderInfo = "2 " + sugarValue + " 70 °C";
      }else{
            orderInfo = "Order error";
      }
    }

  /*  public void openBluetooth(View view){
        if(!adapter.isEnabled()){
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn,0);
            Toast.makeText(getApplicationContext(),"Bluetooth turned on", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Bluetooth already on", Toast.LENGTH_LONG).show();
        }
        if(pairedDevices.size()>0){
            for(BluetoothDevice device : pairedDevices){
                mArrayAdapter.add(device.getName() + "/n" + device.getAddress());
            }


            Intent redirect = new Intent(this, BluetoothMngmtPage.class);
            startActivity(redirect);

        }


    }

*/

    public void toMakeCoffee(View view){
        Intent intent = new Intent(this, MakeCoffeePage.class);

        startActivity(intent);
    }

    public void toChargeBalance(){
        Intent intent = new Intent(this, ChargeBalancePage.class);

        startActivity(intent);
    }


    public void toBluetoothMgmt(View view){
       if( ((GlobalVars)this.getApplication()).getBalance() < priceTotal) {
           AlertDialog.Builder alert = new AlertDialog.Builder(this);
           alert.setTitle("You need " +   ( priceTotal- (((GlobalVars)this.getApplication()).getBalance())) + " $ more to pay");
           // alert.setMessage("Message");

           alert.setPositiveButton("Charge", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int whichButton) {
                   displayWarning();
               }
           });

           alert.setNegativeButton("Cancel",
                   new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int whichButton) {
                       }
                   });

           alert.show();

       }else {
           Intent intent = new Intent(this, BluetoothMngmtPage.class);
           commandGeneration();
           intent.putExtra("orderInfo", orderInfo);
           startActivity(intent);
       }
    }

    public void checkBalance(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Your current balance is: " +    ((GlobalVars)this.getApplication()).getBalance() + " $");
        // alert.setMessage("Message");

        alert.setPositiveButton("Charge", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            displayWarning();
            }
        });

        alert.setNegativeButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    private void displayWarning(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Your order information will be lost, continue? ");
        // alert.setMessage("Message");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            toChargeBalance();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();
    }

}
