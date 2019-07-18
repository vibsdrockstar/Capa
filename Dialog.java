package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
    public void openDetails(View view) {
        switch (view.getId()) {
            case R.id.b_yes:
                startActivity(new Intent(this,Disability.class));
                break;
            case R.id.b_no:
                startActivity(new Intent(this, FirstTimeUsers.class));
                break;
        }
    }
}
