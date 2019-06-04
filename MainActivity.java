package com.example.homeautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button mFirebaseBtn;
    private EditText mNameField;
    private DatabaseReference nDatabase;
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn=(Button)findViewById(R.id.button7);
        mNameField=(EditText)findViewById(R.id.editText);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Name");
        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name=mNameField.getText().toString().trim();
                 mDatabase.push().setValue(name);
            }
        });
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        b4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
         b5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
         b6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        
            

        
        





    }
}

