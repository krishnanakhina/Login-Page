package com.example.payrollmanagerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button eCancel;
    private TextView eAttemptsinfo;

    private String Username = "admin";
    private String Password = "12345678";

    boolean isValid = false;
    private int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eName = findViewById(R.id.email);
        ePassword = findViewById(R.id.password);
        eLogin = findViewById(R.id.btnlogin);
        eCancel = findViewById(R.id.btncancel);
        eAttemptsinfo = findViewById(R.id.tvattempts);

    }

    private boolean validate(String name, String password) {
        if (name.equals(Username) && password.equals(Password)) {
            return true;
        }
        return false;
    }

    public void loginCheck(View view) {
        String inputName = eName.getText().toString();
        String inputPassword = ePassword.getText().toString();

        if (inputName.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(MainActivity.this, "please enter all details correctly", Toast.LENGTH_SHORT).show();

        } else {
            isValid = validate(inputName, inputPassword);
            if (!isValid) {
                counter--;
                Toast.makeText(MainActivity.this, "INCORRECT CREDENTIALS", Toast.LENGTH_SHORT).show();
                eAttemptsinfo.setText("No.of attempts:"+counter);
                if (counter == 0) {
                    eLogin.setEnabled(false);
                }
            }
            else {
                Toast.makeText(MainActivity.this, "login sucessfull", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void clearButton(View view)
    {
        String Text=eCancel.getText().toString();
        if(Text.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Field is empty", Toast.LENGTH_SHORT).show();

        }else
        {
            eCancel.setText("");
        }

    }
}
