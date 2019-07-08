package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CycleParking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_parking);
    }

    public void openSlot(View view) {
        switch (view.getId()) {
            case R.id.b_s1:
                startActivity(new Intent(this, SlotA.class));
                break;
            case R.id.b_s2:
                startActivity(new Intent(this, SlotB.class));
                break;
            case R.id.b_s3:
                startActivity(new Intent(this, SlotC.class));
                break;
            case R.id.b_s4:
                startActivity(new Intent(this, SlotD.class));
                break;
        }
    }
}
