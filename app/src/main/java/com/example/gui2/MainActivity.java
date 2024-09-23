package com.example.gui2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private void innitControl(){
        EditText txtF = findViewById(R.id.txtF);
        EditText txtC = findViewById(R.id.txtC);
        Button btn_ctc = findViewById(R.id.btn_ctc);
        Button btn_ctf = findViewById(R.id.btn_ctf);
        Button btn_clear = findViewById(R.id.clear);


        btn_ctc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String F = txtF.getText().toString();
                if (!F.isEmpty()){
                    double f = Double.parseDouble(F);
                    double c = (f-32)*5/9;
                    txtC.setText(String.format("%.2f",c));
                }else {
                    Toast.makeText(MainActivity.this, "Please enter Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_ctf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String C = txtC.getText().toString();
                if(!C.isEmpty()){
                    double c = Double.parseDouble(C);
                    double f = (c*9/5)+32;
                    txtF.setText(String.format("%2f",f));
                }else{
                    Toast.makeText(MainActivity.this,"Please enter Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtC.setText("");
                txtF.setText("");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        innitControl();
    }
}