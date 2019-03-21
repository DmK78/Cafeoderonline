package com.android.dmk78.cafeoderonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText passEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.editTextName);
        passEditText = findViewById(R.id.editTextPassword);


    }

    public void makeOrder(View view) {

String name = nameEditText.getText().toString().trim();
String pass = passEditText.getText().toString();

        if (!name.equals("") && !pass.equals("")) {

            Intent intent = new Intent(this,CreateOrderActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("pass",pass);
            startActivity(intent);





        } else Toast.makeText(this, getString(R.string.warning_fields), Toast.LENGTH_LONG).show();

    }
}
