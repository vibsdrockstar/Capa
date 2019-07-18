package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }
    public void openInfo(View view) {
        switch (view.getId()) {
            case R.id.b_hist:
                startActivity(new Intent(this, AboutUs.class));
                break;
            case R.id.b_stat:
                startActivity(new Intent(this, SuccessBooking.class));
                break;
            case R.id.b_feature:
                startActivity(new Intent(this, ADMIN.class));
                break;
            case R.id.b_usertype:
                startActivity(new Intent(this, UserType.class));
                break;
                case R.id.b_mobileuser:
              startActivity(new Intent(this,Msgsetting.class));
             break;
case R.id.b_usermessages:
    startActivity(new Intent(this,EmailIntent.class));
    break;
            case R.id.b_pay:
              startActivity(new Intent(this,Payment.class));
    break;
             
        }
    }
}
