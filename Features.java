package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ADMIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void openInformation(View view) {
        switch (view.getId()) {
            case R.id.badd:
                startActivity(new Intent(this, Parking.class));
                break;
            case R.id.b_edit:
                startActivity(new Intent(this, EditProfile.class));
                break;
            case R.id.bview:
                startActivity(new Intent(this, Area.class));
                break;
        }
    }
}
