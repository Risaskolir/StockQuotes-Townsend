package com.example.towns.stockquotes_townsend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button getInfoButton;
    private EditText infoEditText;
    private TextView outputTextView1;
    private TextView outputTextView2;
    private TextView outputTextView3;
    private TextView outputTextView4;
    private TextView outputTextView5;
    private TextView outputTextView6;
    private String inputStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInfoButton = (Button)findViewById(R.id.getInfoButton);
        outputTextView1 = (TextView)findViewById(R.id.outputTextView1);
        outputTextView2 = (TextView)findViewById(R.id.outputTextView2);
        outputTextView3 = (TextView)findViewById(R.id.outputTextView3);
        outputTextView4 = (TextView)findViewById(R.id.outputTextView4);
        outputTextView5 = (TextView)findViewById(R.id.outputTextView5);
        outputTextView6 = (TextView)findViewById(R.id.outputTextView6);
        infoEditText = (EditText)findViewById(R.id.infoEditText);

        getInfoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                inputStr = infoEditText.getText().toString();
                Stock inputStock = new Stock(inputStr);
                try{
                    //make thread here, maybe outside try/catch.
                   inputStock.load();
                }
                catch(IOException e){

                }
            }
        });


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("outputText1",outputTextView1.getText().toString());
        outState.putString("outputText2",outputTextView2.getText().toString());
        outState.putString("outputText3",outputTextView3.getText().toString());
        outState.putString("outputText4",outputTextView4.getText().toString());
        outState.putString("outputText5",outputTextView5.getText().toString());
        outState.putString("outputText6",outputTextView6.getText().toString());
        outState.putString("editTextInfo",infoEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        outputTextView1.setText(savedInstanceState.getString("outputText1"));
        outputTextView2.setText(savedInstanceState.getString("outputText2"));
        outputTextView3.setText(savedInstanceState.getString("outputText3"));
        outputTextView4.setText(savedInstanceState.getString("outputText4"));
        outputTextView5.setText(savedInstanceState.getString("outputText5"));
        outputTextView6.setText(savedInstanceState.getString("outputText6"));
        infoEditText.setText(savedInstanceState.getString("editTextInfo"));
    }
}