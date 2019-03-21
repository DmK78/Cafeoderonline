package com.android.dmk78.cafeoderonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SendOrderActivity extends AppCompatActivity {
    TextView textViewOrderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);

        textViewOrderTotal = findViewById(R.id.textViewOrderTotal);
        Intent intent = getIntent();
        String s = intent.getStringExtra("orderTotal");
        textViewOrderTotal.setText(s);


    }
}
