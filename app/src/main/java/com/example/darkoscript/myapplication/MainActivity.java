package com.example.darkoscript.myapplication;

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


//set the a listener for the changes on radio buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                if(checkedRadioButton == checkedRadioButtonWithdraw){
                    transaction_type.setText("withdraw charge");
                    Toast.makeText(MainActivity.this, "withdraw radio button has been selected", Toast.LENGTH_LONG).show();
                }
                else if (checkedRadioButton == checkedRadioButtonSend){
                    transaction_type.setText("sending charge");
                    Toast.makeText(MainActivity.this, "send radio button has been selected", Toast.LENGTH_LONG).show();
                }
            }
        });
        //set onclick listener for the button
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check to ensure it is not empty
               if (!value_amount.getText().toString().isEmpty()){
                   // type conversion of input to integer
                   int value = Integer.parseInt(value_amount.getText().toString().trim());
                  if(radioGroup.getCheckedRadioButtonId() == withdraw_radio_button.getId()){

                  }
               }
            }
        });
    }
}
