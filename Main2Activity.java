package com.examples.bindanaik.vegetables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText name;
    EditText pass;
    EditText confirmpass;
    Button submit;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        confirmpass=(EditText)findViewById(R.id.confirmpass);
        submit=(Button)findViewById(R.id.submit);
    }
    public void submit(View view){
        String user=name.getText().toString().trim();
        String passw=pass.getText().toString().trim();
        String cnf_pass=confirmpass.getText().toString().trim();

        if(passw.equals(cnf_pass)){
            long val=db.addUser(user,passw);
            if(val>0){
            Toast.makeText(Main2Activity.this,"Registration success",Toast.LENGTH_LONG);
            Intent submit=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(submit);
        }else{
                Toast.makeText(Main2Activity.this,"Registration error",Toast.LENGTH_LONG);
            }
        }
        else{
            Toast.makeText(Main2Activity.this,"Password not matching",Toast.LENGTH_LONG);
        }


    }

}
