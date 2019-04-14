package com.examples.bindanaik.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button registerid;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        registerid = (Button) findViewById(R.id.register);


    }
    public void loginside(View view){
        String user=username.getText().toString().trim();
        String pwd=password.getText().toString().trim();
        Boolean res=db.CheckUser(user,pwd);
        if(res==true){
            Toast.makeText(MainActivity.this,"successful Login!",Toast.LENGTH_LONG);
        }
        else{
            Toast.makeText(MainActivity.this,"Invalid Login Details",Toast.LENGTH_LONG);
        }
    }

    public void registerit(View view){
        Intent registeri=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(registeri);
    }

}