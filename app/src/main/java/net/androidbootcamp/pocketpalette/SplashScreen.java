package net.androidbootcamp.pocketpalette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                //Display Main activity after splash screen
                startActivity(new Intent(SplashScreen.this, MainMenu.class));
            }
        };
        //creates TimerTask object that displays main activity after 5000ms
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}