package com.example.savethecurrentstatechallange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    TextView CountTtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountTtext =findViewById(R.id.count_text);
        if(savedInstanceState!=null){
            boolean isVisible=savedInstanceState.getBoolean("reply_visible");
            if(isVisible){
                CountTtext.setText(savedInstanceState.getString("reply_text"));
                CountTtext.setVisibility(View.VISIBLE);
            }
        }
    }

    public void count(View view) {
        count++;
        if(CountTtext!=null) CountTtext.setText(Integer.toString(count));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        if(CountTtext.getVisibility()==View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text",CountTtext.getText().toString());
        }
    }
}