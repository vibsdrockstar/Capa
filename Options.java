package com.example.name;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }
    public void OpenInstructionPage(View view) {
        switch (view.getId()) {

            case R.id.bhear:
                startActivity(new Intent(this, Audio.class));
                break;
            case R.id.bsee:
                startActivity(new Intent(this, Read.class));
                break;
        }
    }
}
