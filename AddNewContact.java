package com.example.tito.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {
    EditText name,mobile_number,email;
    Button save;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper=new DatabaseHelper(this);
        setContentView(R.layout.activity_add_new_contact);
        name=(EditText)findViewById(R.id.n);
        mobile_number=(EditText)findViewById(R.id.m);
        email=(EditText)findViewById(R.id.e);
        save=(Button)findViewById(R.id.sb);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             boolean result=databaseHelper.insertdata(name.getText().toString(),Integer.parseInt(mobile_number.getText().toString()),
                     email.getText().toString());

            if(result)
                Toast.makeText(AddNewContact.this,"Data Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
