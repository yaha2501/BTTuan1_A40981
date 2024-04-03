package com.example.b2.tuan2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

public class Tuan2MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan2_main);
        txt1 = findViewById(R.id.Tuan2txt1);
        txt2 = findViewById(R.id.Tuan2txt2);
        btn = findViewById(R.id.Tuan2btn);
        btn.setOnClickListener(v->{
            // dinh huong di chuyen
            Intent i = new Intent(Tuan2MainActivity.this, Tuan21MainActivity.class);
            // dua data vao
            i.putExtra("number1",txt1.getText().toString());
            i.putExtra("number2", txt2.getText().toString());
            // khoi hanh Start
            startActivity(i);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}