package com.example.validationexamplle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class nextintent extends AppCompatActivity {
    TextView tname1,temail,tnumber,tpwd,tconpwd,txender,thobies;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextintent);
        tname1=findViewById(R.id.tname);
        temail=findViewById(R.id.temail);
        tnumber=findViewById(R.id.tnumber);
        tpwd=findViewById(R.id.tpassword);
        tconpwd=findViewById(R.id.tconpwd);
        txender=findViewById(R.id.txender);
        thobies=findViewById(R.id.thobie);

        b2=findViewById(R.id.cancel);


        Intent i1=getIntent();
        String nm=i1.getStringExtra("p_nm");
        tname1.setText(nm);
        String email=i1.getStringExtra("pem");
        temail.setText(email);
        String number=i1.getStringExtra("n1");
        tnumber.setText(number);
        String password=i1.getStringExtra("ppwd");
        tpwd.setText(password);
        String conpwd=i1.getStringExtra("conpwd1");
        tconpwd.setText(conpwd);
        String xender=i1.getStringExtra("m1");
        txender.setText(xender);
        String hobies=i1.getStringExtra("ps");
        thobies.setText(hobies);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(nextintent.this,MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"form cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
