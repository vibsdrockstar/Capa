package com.example.parker;
import android.speech.tts.TextToSpeech;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import java.util.Locale;
import android.view.View;
import android.os.Bundle;

public class ParkCost extends AppCompatActivity {
    Button btnspeech;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_cost);
        btnspeech=(Button)findViewById(R.id.b_play);
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });
        btnspeech.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                textToSpeech.speak("Hello User for parking duration of 15 minutes Cost is Rs 30, for parking duration of 20 minutes cost is Rs 40,for parking duration of 25 minutes cost is Rs 50, for 30 minutes cost is Rs 60 and for more than or equal to 1 hour parking cost is Rs 100",TextToSpeech.QUEUE_FLUSH,null);
    }

});
}
}
