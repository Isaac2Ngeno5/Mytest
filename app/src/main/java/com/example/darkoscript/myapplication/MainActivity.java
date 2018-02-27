package com.example.darkoscript.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton withdraw_radio_button;
    RadioButton send_radio_button;
    TextView transaction_type;
    Button calculate_button;
    EditText value_amount;
    TextView fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//declare the variables
        radioGroup = findViewById(R.id.radioGroup);
        withdraw_radio_button = findViewById(R.id.withdraw_radio_button);
        send_radio_button = findViewById(R.id.send_radio_button);
        transaction_type = findViewById(R.id.transaction_type);
        calculate_button = findViewById(R.id.calculate_button);
        value_amount = findViewById(R.id.value_amount);
        fee = findViewById(R.id.fee);

//set the a listener for the changes on radio buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //create variables to store the id of each radio button which will be used to compare with the id of checked button
                int checkedRadioButton;
                checkedRadioButton = radioGroup.getCheckedRadioButtonId();
                int checkedRadioButtonWithdraw;
                checkedRadioButtonWithdraw = withdraw_radio_button.getId();
                int checkedRadioButtonSend;
                checkedRadioButtonSend = send_radio_button.getId();
                //compare the checked id with id of button selected
                if (checkedRadioButton == checkedRadioButtonWithdraw) {
                    transaction_type.setText("withdraw charge");
                    //Toast.makeText(MainActivity.this, "withdraw radio button has been selected", Toast.LENGTH_LONG).show();
                } else if (checkedRadioButton == checkedRadioButtonSend) {
                    transaction_type.setText("sending charge");
                    //Toast.makeText(MainActivity.this, "send radio button has been selected", Toast.LENGTH_LONG).show();
                }
            }
        });

        //set onclick listener for the button
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // check to ensure it is not empty
                if (!value_amount.getText().toString().isEmpty()) {
                    // type conversion of input to integer
                    int value = Integer.parseInt(value_amount.getText().toString().trim());
                    if (radioGroup.getCheckedRadioButtonId() == withdraw_radio_button.getId()) {
                        getWithdrawFee(value);
                    }else if(radioGroup.getCheckedRadioButtonId() == send_radio_button.getId()){
                        getSendFee(value);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "please enter amount", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void getWithdrawFee(int value) {
        if ((value < 49) && (value > 10)) {
            fee.setText("ksh : " + 0);
        } else if ((value < 100) && (value > 50)) {
            fee.setText("ksh : " + 10);
        } else if ((value < 2500) && (value > 101)) {
            fee.setText("ksh : " + 27);
        } else if ((value < 3500) && (value > 2501)) {
            fee.setText("ksh : " + 49);
        } else if ((value < 5000) && (value > 3501)) {
            fee.setText("ksh : " + 66);
        } else if ((value < 7500) && (value > 5001)) {
            fee.setText("ksh : " + 82);
        } else if ((value < 10000) && (value > 7501)) {
            fee.setText("ksh : " + 110);
        } else if ((value < 15000) && (value > 10001)) {
            fee.setText("ksh : " + 159);
        } else if ((value < 20000) && (value > 15001)) {
            fee.setText("ksh : " + 176);
        } else if ((value < 35000) && (value > 20001)) {
            fee.setText("ksh : " + 187);
        } else if ((value < 50000) && (value > 35001)) {
            fee.setText("ksh : " + 275);
        } else if ((value < 70000) && (value > 50001)) {
            fee.setText("ksh : " + 330);
        }else if(value > 70000){
            fee.setText("amount entered exceeds withdraw limit" );
        }
    }

    @SuppressLint("SetTextI18n")
    private void getSendFee(int value){
        if ((value < 49) && (value > 10)) {
            fee.setText("ksh : " + 1);
        } else if ((value < 100) && (value > 50)) {
            fee.setText("ksh : " + 3);
        } else if ((value < 500) && (value > 101)) {
            fee.setText("ksh : " + 11);
        } else if ((value < 1000) && (value > 501)) {
            fee.setText("ksh : " + 15);
        } else if ((value < 1500) && (value > 1001)) {
            fee.setText("ksh : " + 25);
        } else if ((value < 2500) && (value > 1501)) {
            fee.setText("ksh : " + 40);
        } else if ((value < 3500) && (value > 2501)) {
            fee.setText("ksh : " + 55);
        } else if ((value < 5000) && (value > 3501)) {
            fee.setText("ksh : " + 60);
        } else if ((value < 7500) && (value > 5001)) {
            fee.setText("ksh : " + 75);
        } else if ((value < 10000) && (value > 7501)) {
            fee.setText("ksh : " + 85);
        } else if ((value < 15000) && (value > 10001)) {
            fee.setText("ksh : " + 95);
        } else if ((value < 20000) && (value > 15001)) {
            fee.setText("ksh : " + 100);
        }else if ((value < 70000) && (value > 20001)) {
            fee.setText("ksh : " + 110);
        }else if(value > 70000){
            fee.setText("amount entered exceeds send limit" );
        }
    }
}
