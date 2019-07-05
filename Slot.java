package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SlotInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_info);
    }
    public void openSlot(View view) {
        switch (view.getId()) {
            case R.id.b_s1:
                startActivity(new Intent(this, Slot1.class));
                break;
            case R.id.b_s2:
                startActivity(new Intent(this, Slot2.class));
                break;
            case R.id.b_s3:
                startActivity(new Intent(this, Slot3.class));
                break;
            case R.id.b_s4:
                startActivity(new Intent(this, Slot4.class));
                break;

        }
    }
}
