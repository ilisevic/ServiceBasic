package com.boilerplatecode.servicebasic;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText editTextInput;
private Button btnStart, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput= findViewById(R.id.edit_text_input);
        btnStart = findViewById(R.id.btnStartService);
        btnStop = findViewById(R.id.btnStopService);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
stopService();
            }
        });
    }

    public void startService ()
    {

        String input = editTextInput.getText().toString();
        Intent serviceIntent = new Intent(this, ExampleService.class);
        // TODO ispod "inputExtra" treba biti final  varijabla
        serviceIntent.putExtra("inputExtra",input);

        //TODO alternativno može i startService ali on nije foregrond i kilnut je poslije minut
        ContextCompat.startForegroundService(this,serviceIntent);


    }

    public void  stopService()
    {
        Intent serviceIntent = new Intent(this,ExampleService.class);
        stopService(serviceIntent);

    }


}
