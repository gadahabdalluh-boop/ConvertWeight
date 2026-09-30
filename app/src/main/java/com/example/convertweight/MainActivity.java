package com.example.convertweight;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        EditText edtWeight = findViewById(R.id.edtWeight);
        RadioButton rbPoundsToKg = findViewById(R.id.rbPoundsToKg);
        RadioButton rbKgToPounds = findViewById(R.id.rbKgToPounds);
        Button btnConvert = findViewById(R.id.btnConvert);
        TextView txtResult = findViewById(R.id.txtResult);

        btnConvert.setOnClickListener(v -> {
            String input = edtWeight.getText().toString();
            if (input.isEmpty()) {
                edtWeight.setError("Enter weight");
                return;
            }
            double weight = Double.parseDouble(input);
            double result;

            if (rbPoundsToKg.isChecked()) {
                result = weight * 0.453592;   // pounds to kg
                txtResult.setText(String.format("%.1f kilograms", result));
            } else if (rbKgToPounds.isChecked()) {
                result = weight / 0.453592;   // kg to pounds
                txtResult.setText(String.format("%.1f pounds", result));
            }


        });
        ;}
}


