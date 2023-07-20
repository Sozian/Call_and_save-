package com.example.call_and_save;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
   Button BtnSave,BtnClear,BtnDial;
   EditText phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnSave=findViewById(R.id.BtnSave);
        BtnDial=findViewById(R.id.BtnCall);
        BtnClear=findViewById(R.id.BtnClear);
        phoneNumber=findViewById(R.id.ph);
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber.setText("");
            }
        });
        BtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber1=phoneNumber.getText().toString();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber1));
                startActivity(intent);
            }
        });
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber1=phoneNumber.getText().toString();
                Intent intent=new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,phoneNumber1);
                startActivity(intent);
            }
        });
        }
        public void inputNumber(View view){
        Button btn=(Button)view;
        String digit=btn.getText().toString();
        String phoneNumber1=phoneNumber.getText().toString();
        phoneNumber.setText(phoneNumber1+digit);
        }
}
