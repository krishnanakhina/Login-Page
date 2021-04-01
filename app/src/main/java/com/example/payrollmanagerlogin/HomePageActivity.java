package com.example.payrollmanagerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {
    SharedPreferences share;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView page=(TextView)findViewById(R.id.resultView);
        share=getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(HomePageActivity.this,MainActivity.class);
        page.setText("Welcome," +share.getString("share",null));

    }
}