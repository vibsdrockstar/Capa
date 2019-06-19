package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MessageStore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_store);
    }

    public void openMessages(View view) {
        switch (view.getId()) {
            case R.id.b_send:
                startActivity(new Intent(this, Send.class));
                break;
            case R.id.b_receive:
                startActivity(new Intent(this, Recieved.class));
                break;
        }
    }
}
