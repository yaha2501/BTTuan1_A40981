package com.example.b2.Tuan3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

public class Tuan31MainActivity extends AppCompatActivity {
    EditText txt1,txt2,txt3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan31_main);
        txt1 = findViewById(R.id.Tuan31Edittext1);
        txt2 = findViewById(R.id.Tuan31Edittext2);
        txt3 = findViewById(R.id.Tuan31Edittext3);
        btn = findViewById(R.id.Tuan31Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent it = new Intent(Tuan31MainActivity.this, Tuan32MainActivity.class);
            it.putExtra("a",txt1.getText().toString());
            it.putExtra("b",txt2.getText().toString());
            it.putExtra("c",txt3.getText().toString());
            startActivity(it);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}