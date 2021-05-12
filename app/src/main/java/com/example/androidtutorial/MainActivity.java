package com.example.androidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getBackground() instanceof ColorDrawable) {
                    ColorDrawable cd = (ColorDrawable) textView.getBackground();
                    int colorCode = cd.getColor();
                }
                textView.setText("Black Munde");
                textView.setBackgroundColor(getResources().getColor(R.color.black));
                Toast.makeText(getApplicationContext(), "Color Changed", Toast.LENGTH_SHORT).show();
            }
        }
        );
    }
}