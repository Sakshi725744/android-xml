package com.example.homeautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Chronometer;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {
    private Button mFirebaseBtn;
    private EditText mNameField;
    private DatabaseReference nDatabase;
    Chronometer cmTimer, cmTimer2, cmTimer3;
    Boolean resume = false;
    long elapsedTime;
    String TAG = "TAG";
    Button b1, b2, b3, b4, b5, b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.button7);
        mNameField = (EditText) findViewById(R.id.editText);
        cmTimer = (Chronometer) findViewById(R.id.cmTimer);
        cmTimer2 = (Chronometer) findViewById(R.id.cmTimer2);
        cmTimer3 = (Chronometer) findViewById(R.id.cmTimer3);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Name");
        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString().trim();
                mDatabase.push().setValue(name);
            }
        });
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);


        cmTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            public void onChronometerTick(Chronometer arg0) {
                if (!resume) {
                    long minutes = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) / 60;
                    long seconds = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) % 60;
                    elapsedTime = SystemClock.elapsedRealtime();
                    Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
                } else {
                    long minutes = ((elapsedTime - cmTimer.getBase()) / 1000) / 60;
                    long seconds = ((elapsedTime - cmTimer.getBase()) / 1000) % 60;
                    elapsedTime = elapsedTime + 1000;
                    Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
                }
            }
        });

    }
    cmTimer2.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()

    {
        public void onChronometerTick (Chronometer arg0){
        if (!resume) {
            long minutes = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) / 60;
            long seconds = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) % 60;
            elapsedTime = SystemClock.elapsedRealtime();
            Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
        } else {
            long minutes = ((elapsedTime - cmTimer.getBase()) / 1000) / 60;
            long seconds = ((elapsedTime - cmTimer.getBase()) / 1000) % 60;
            elapsedTime = elapsedTime + 1000;
            Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
        }
    }
    });

    cmTimer3.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()

    {
        public void onChronometerTick (Chronometer arg0){
        if (!resume) {
            long minutes = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) / 60;
            long seconds = ((SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000) % 60;
            elapsedTime = SystemClock.elapsedRealtime();
            Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
        } else {
            long minutes = ((elapsedTime - cmTimer.getBase()) / 1000) / 60;
            long seconds = ((elapsedTime - cmTimer.getBase()) / 1000) % 60;
            elapsedTime = elapsedTime + 1000;
            Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
        }
    }
    });
}

    int a,b,c;
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                b1.setEnabled(false);
                b2.setEnabled(true);

                if (!resume) {
                    cmTimer.setBase(SystemClock.elapsedRealtime());
                    cmTimer.start();
                } else {
                    cmTimer.start();
                }
                break;
            case R.id.button2:
                String chronoText = cmTimer.getText().toString();
                String array[] = chronoText.split(":");
                    a = Integer.parseInt(array[0]) * 60 * 1000
                            + Integer.parseInt(array[1]) * 1000;
                cmTimer.stop();
                cmTimer.setText("00:00");
                resume = false;

                break;
            case R.id.button3:
                b3.setEnabled(false);
                b4.setEnabled(true);

                if (!resume) {
                    cmTimer2.setBase(SystemClock.elapsedRealtime());
                    cmTimer2.start();
                } else {
                    cmTimer2.start();
                }
                break;
            case R.id.button4:
                String chronoText = cmTimer.getText().toString();
                String array[] = chronoText.split(":");
                b = Integer.parseInt(array[0]) * 60 * 1000
                        + Integer.parseInt(array[1]) * 1000;
                cmTimer2.stop();
                cmTimer2.setText("00:00");
                resume = false;

                break;
            case R.id.button5:
                b5.setEnabled(false);
                b6.setEnabled(true);

                if (!resume) {
                    cmTimer3.setBase(SystemClock.elapsedRealtime());
                    cmTimer3.start();
                } else {
                    cmTimer3.start();
                }
                break;
            case R.id.button6:
                cmTimer3.stop();
                String chronoText = cmTimer.getText().toString();
                String array[] = chronoText.split(":");
                c = Integer.parseInt(array[0]) * 60 * 1000
                        + Integer.parseInt(array[1]) * 1000;
                cmTimer3.setText("00:00");
                resume = false;
                break;}}


                editText1.setText(String.Valueof(a));
                editText2.setText(String.Valueof(b));
                editText3.setText(String.Valueof(c));


