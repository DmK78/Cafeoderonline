package com.android.dmk78.cafeoderonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class CreateOrderActivity extends AppCompatActivity {
    private String name;
    private String pass;
    RadioButton radioButtonTea;
    RadioButton radioButtonCoffee;
    CheckBox checkBoxMilk;
    CheckBox checkBoxSugar;
    CheckBox checkBoxLemon;
    Spinner spinnerTea;
    Spinner spinnerCoffee;
    TextView textViewHello;
    TextView textViewAddition;
    TextView textViewChoose;
    String choosenDrink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);


        Intent getIntent = getIntent();
        if (getIntent.hasExtra("name") && getIntent.hasExtra("pass")) {
            name = getIntent.getStringExtra("name");
            pass = getIntent.getStringExtra("pass");
        } else {
            name = getString(R.string.default_name);
            pass = getString(R.string.default_pass);
        }


        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        spinnerTea = findViewById(R.id.spinnerTea);
        checkBoxLemon = findViewById(R.id.checkboxLemon);
        checkBoxMilk = findViewById(R.id.checkboxMilk);
        checkBoxSugar = findViewById(R.id.checkboxSugar);
        textViewHello = findViewById(R.id.helloTextView);
        textViewAddition = findViewById(R.id.additionTextView);
        textViewChoose = findViewById(R.id.textViewChoose);

        textViewHello.setText(getString(R.string.hello_user) + name + getString(R.string.ask_user_order));
        textViewAddition.setText(getString(R.string.addition_title) + getString(R.string.tea));
        textViewChoose.setText(getString(R.string.choose_a_drink_title) + getString(R.string.tea));
        choosenDrink = getString(R.string.tea);


    }

    public void onClickChangeDrink(View view) {
        if (radioButtonCoffee.isChecked()) {

            spinnerCoffee.setVisibility(VISIBLE);
            spinnerTea.setVisibility(View.INVISIBLE);
            checkBoxLemon.setVisibility(View.INVISIBLE);
            textViewAddition.setText(getString(R.string.addition_title) + getString(R.string.coffee));
            textViewChoose.setText(getString(R.string.choose_a_drink_title) + getString(R.string.coffee));
            choosenDrink = getString(R.string.coffee);


        } else if (radioButtonTea.isChecked()) {
            spinnerCoffee.setVisibility(View.INVISIBLE);
            spinnerTea.setVisibility(VISIBLE);
            checkBoxLemon.setVisibility(VISIBLE);
            textViewAddition.setText(getString(R.string.addition_title) + getString(R.string.tea));
            textViewChoose.setText(getString(R.string.choose_a_drink_title) + getString(R.string.tea));
            choosenDrink = getString(R.string.tea);
        }


    }

    public void onClickSendOrder(View view) {
        StringBuilder orderTotal = new StringBuilder();
        orderTotal.append(name + ", ");
        orderTotal.append(pass + ", ");


        if (choosenDrink == (getString(R.string.tea))) {
            orderTotal.append(getString(R.string.tea) + " - ");
            orderTotal.append(spinnerTea.getSelectedItem().toString() + ", ");

            if (checkBoxLemon.isChecked()) {
                orderTotal.append(getString(R.string.checkbox_lemon_title) + ", ");
            }
            if (checkBoxMilk.isChecked()) {
                orderTotal.append(getString(R.string.checkbox_milk_title) + ", ");
            }
            if (checkBoxSugar.isChecked()) {
                orderTotal.append(getString(R.string.checkbox_sugar_title) + ".");
            }

        } else if (choosenDrink == (getString(R.string.coffee))) {
            orderTotal.append(getString(R.string.coffee) + " - ");
            orderTotal.append(spinnerCoffee.getSelectedItem().toString() + ", ");

            if (checkBoxMilk.isChecked()) {
                orderTotal.append(getString(R.string.checkbox_milk_title) + ", ");
            }
            if (checkBoxSugar.isChecked()) {
                orderTotal.append(getString(R.string.checkbox_sugar_title) + ".");
            }


        }


        Intent intent = new Intent(this, SendOrderActivity.class);
        intent.putExtra("orderTotal", orderTotal.toString());
        Log.i("orderTotal", orderTotal.toString());


        startActivity(intent);


    }
}
