package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
    }

    public void openLogin(View view) {
        switch (view.getId()) {
            case R.id.b_guestuser:
                startActivity(new Intent(this, FirstTimeUsers.class));
                break;
            case R.id.b_reguser:
                startActivity(new Intent(this, Details.class));
                break;
        }
    }
}
