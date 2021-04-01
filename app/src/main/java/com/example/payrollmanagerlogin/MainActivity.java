package com.example.payrollmanagerlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.pm.PackageInfoCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    private EditText eId;
    private EditText ePassword;
    private Button eLogin;
    CheckBox eRemember;
    private Button eCancel;
    SharedPreferences share;
    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eId = findViewById(R.id.email);
        ePassword = findViewById(R.id.password);
        eLogin = findViewById(R.id.btnlogin);
        eRemember = findViewById(R.id.remember);
        eCancel = findViewById(R.id.btncancel);
        share = getSharedPreferences("share", MODE_PRIVATE);
    }

    public void loginCheck(View view) {
        String inputName = eId.getText().toString();
        String inputPassword = ePassword.getText().toString();
        boolean checked = eRemember.isChecked();

        SharedPreferences.Editor editor = share.edit();
        editor.putString("10", "arun@123");
        editor.putString("22", "benny@123");
        editor.putString("33", "catherine@123");
        editor.putString("44", "denny@123");
        editor.putString("55", "esha@123");
        editor.apply();

        if (share.contains(inputName)) {
            inputName.equals(share.getString(inputName, ""));
                Toast.makeText(MainActivity.this, "login sucessfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
            } else if (share.contains(inputPassword)) {
                inputPassword.equals(share.getString(inputPassword, ""));
            } else if (inputName.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(MainActivity.this, "please enter all details correctly", Toast.LENGTH_SHORT).show();
            }
        }
    
        public void clearButton (View view)
        {
            eId.setText("");
            ePassword.setText("");
        }

    }






