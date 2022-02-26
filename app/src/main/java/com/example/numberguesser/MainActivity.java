package com.example.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Variables

    // Settings
    int outputMin;
    int outputMax;

    // App Variables
    Integer inputNum;
    Integer outputNum;
    String outputString;

    // Components
    EditText inputComp;
    TextView outputComp;
    Button submitComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Default app settings
        outputMin = 1;
        outputMax = 10;

        // Start
        setContentView(R.layout.activity_main);

        // Link components
        inputComp = (EditText) findViewById(R.id.Input);
        outputComp = (TextView) findViewById(R.id.Output);
        submitComp = (Button) findViewById(R.id.SubmitButton);
        submitComp.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View V){
                        try {
                            // Get input
                            inputNum = inputNum.valueOf(inputComp.getText().toString());
                            // Check if input is valid
                            if (inputNum >= 1 && inputNum <= 10) {
                                inputNum = inputNum.valueOf(inputComp.getText().toString());
                                outputNum = (int) (outputMin + Math.random() * outputMax);
                                outputString = outputNum.toString();

                                // Calculate number difference and output
                                if (outputNum - inputNum == 0) {
                                    outputComp.setText("BINGO!!!");
                                } else if (outputNum - inputNum > 0 && outputNum - inputNum <= 2 || outputNum - inputNum < 0 && outputNum - inputNum >= -2) {
                                    outputComp.setText("CLOSE!");
                                } else if (outputNum - inputNum >= 3 || outputNum - inputNum <= -3) {
                                    outputComp.setText("Far...");
                                }

                            } else { outputComp.setText("Invalid Input"); }
                        } catch (Exception e){}
                    }
                });
    }
}