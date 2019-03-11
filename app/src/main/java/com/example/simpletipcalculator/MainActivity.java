package com.example.simpletipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    EditText txtTipPercentage, txtMealCost;
    TextView textTotalTip, textTotalMealCost;
    Button btnCalculate, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.button);
        btnClear = findViewById(R.id.button2);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
                hideKeyboard();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearApp();
                hideKeyboard();
            }
        });

    }
    private void calculateTip(){
        // input getters
        txtTipPercentage = findViewById(R.id.editText2);
        txtMealCost = findViewById(R.id.editText);
        textTotalTip = findViewById(R.id.textView2);
        textTotalMealCost = findViewById(R.id.textView3);

        double tipPercentage = Double.parseDouble(txtTipPercentage.getText().toString());
        double mealCost = Double.parseDouble(txtMealCost.getText().toString());
        //Variables
        double totalMealcost;
        double totalTip;
        tipPercentage = tipPercentage * 0.01;
        totalTip = mealCost * tipPercentage;
        totalMealcost = mealCost + totalTip;

        String roundtotalTip = String.format("%1.2f", totalTip);
        String roundtotalMealCost = String.format("%1.2f", totalMealcost);


        textTotalTip.setText("Total tip: $" + roundtotalTip);
        textTotalMealCost.setText("Total Meal Cost: $" + roundtotalMealCost);

    }
    private void clearApp(){
        txtTipPercentage.setText("");
        txtMealCost.setText("");
        textTotalTip.setText("Total Tip: $0.00");
        textTotalMealCost.setText("Total Meal Cost: $0.00");
    }
    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(txtMealCost.getWindowToken(),0);
    }

}
