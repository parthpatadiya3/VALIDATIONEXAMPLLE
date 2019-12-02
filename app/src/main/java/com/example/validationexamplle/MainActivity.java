package com.example.validationexamplle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email, pwd, conpwd,number;
    RadioGroup r1;
    RadioButton male,female;
    CheckBox sport, reading, travelling;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.Bb1);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                name=findViewById(R.id.ed_name);
                email=findViewById(R.id.ed_email);
                pwd=findViewById(R.id.ed_pwd);
                conpwd=findViewById(R.id.ed_conpwd);
                r1=findViewById(R.id.rg1);
                male=findViewById(R.id.r_male);
                sport=findViewById(R.id.c_sport);
                reading=findViewById(R.id.c_reading);
                travelling=findViewById(R.id.c_travell);
                female=findViewById(R.id.r_female);
                number=findViewById(R.id.number);



                final String e1=email.getText().toString();
                final String epattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


                Intent i=new Intent(MainActivity.this,nextintent.class);
                if(name.getText().toString().length()>0)
                {
                    String nm=name.getText().toString();
                    i.putExtra("p_nm",nm);

                }
                else
                {

                    name.setError("enter valid name");

                }
                if ((email.getText().toString().length()>0)&&(e1.matches(epattern)))
                {
                    String em=email.getText().toString();
                    i.putExtra("pem",em);
                }
                else
                {
                    email.setError("invalid email");
                }
                if(pwd.getText().toString().length()>0)
                {
                    String pwd1=pwd.getText().toString();
                    i.putExtra("ppwd",pwd1);
                }
                else
                {
                    pwd.setError("set any pwd");
                }
                if(conpwd.getText().toString().equals(pwd.getText().toString()))
                {
                    String conpwd1=conpwd.getText().toString();
                    i.putExtra("conpwd1",conpwd1);

                }
                else
                {
                    conpwd.setError("dont match");
                }
                if((male.isChecked())||(female.isChecked())) {
                    if (male.isChecked())
                    {
                        String m1 = male.getText().toString();
                        i.putExtra("m1", m1);
                    }
                    else
                    {
                        String m1 = female.getText().toString();
                        i.putExtra("m1", m1);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"check any radio",Toast.LENGTH_SHORT).show();
                }
                if(number.getText().toString().length()==10)
                {
                    String n1=number.getText().toString();
                    i.putExtra("n1",n1);
                }
                else
                {
                    number.setError("enter valid number");
                }
                if(sport.isChecked()||travelling.isChecked()||reading.isChecked())
                {
                    String c1="";
                    if(sport.isChecked())
                    {
                        c1 += sport.getText().toString().toUpperCase()+"\n";
                        i.putExtra("ps", c1);
                    }
                    if(travelling.isChecked())
                    {
                        c1 += travelling.getText().toString().toUpperCase()+"\n";
                        i.putExtra("ps", c1);
                    }
                    if(reading.isChecked())
                    {
                        c1 += reading.getText().toString().toUpperCase()+"\n";
                        i.putExtra("ps", c1);
                    }
                }
                else
                {

                }

                if((name.getText().toString().length()>0)&&((email.getText().toString().length()>0)&&(e1.matches(epattern)))&&(pwd.getText().toString().length()>0)&&(conpwd.getText().toString().equals(pwd.getText().toString()))&&(number.getText().toString().length()==10)&&(male.isChecked())||(female.isChecked()))
                {
                    if(sport.isChecked()||travelling.isChecked()||reading.isChecked())
                        startActivity(i);
                }
            }


        });


    }
}
