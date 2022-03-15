package com.example.myloginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView email= (TextView) findViewById(R.id.emailaddress);
        TextView password= (TextView) findViewById(R.id.password);

        MaterialButton button= (MaterialButton) findViewById(R.id.loginbutton);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean flag = validateEmailAddress(email);
                if(flag && email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin123"))
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                else if(flag && (!email.getText().toString().equals("admin@gmail.com")) && (!password.getText().toString().equals("admin")))
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                else if(!flag)
                    Toast.makeText(MainActivity.this,"Invalid E-mail Address!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private boolean validateEmailAddress(TextView textView)
    {
        String emailInput=textView.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
            return true;
        else
        {
            //Toast.makeText(MainActivity.this,"Invalid E-mail Address!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}