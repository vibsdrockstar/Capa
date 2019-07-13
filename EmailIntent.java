package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailIntent extends AppCompatActivity {
private EditText mEditTextTo;
private EditText mEditTextSub;
private EditText mEditTextMess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_intent);
        mEditTextTo= findViewById(R.id.et_to);
        mEditTextSub=findViewById(R.id.et_textSubject);
        mEditTextMess=findViewById(R.id.et_message);
        Button buttonsend=findViewById(R.id.bt_send);
        buttonsend.setOnClickListener(new view.onClickListener() {
            @Override
            public void onClick(View v){

            sendmail();
        }
        });
}
private void sendmail(){
    String reciepentList= mEditTextTo.getText().toString();
    String[]reciepents=reciepentList.split(",");

    String subject= mEditTextSub.getText().toString();
    String message = mEditTextMess.getText().toString();
    Intent intent =new Intent(Intent.ACTION_SEND);
    intent.putExtra(Intent.EXTRA_EMAIL,reciepents);
    intent.putExtra(Intent.EXTRA_SUBJECT,subject);
    intent.putExtra(Intent.EXTRA_TEXT,message);
    intent.setType("message/abc123");
    startActivity(Intent.createChooser(intent,"Chose an Email Client"));
    }
}
