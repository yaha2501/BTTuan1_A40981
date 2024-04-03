package com.example.b2.tuan2;

import android.annotation.SuppressLint;
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

public class Tuan23MainActivity extends AppCompatActivity {
    EditText tx1, tx2;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan23_main);
        tx1 = findViewById(R.id.Tuan23Edittext1);
        tx2 = findViewById(R.id.Tuan23Edittext2);
        btn = findViewById(R.id.Tuan23Button);
        btn.setOnClickListener(v->{
            // dinh huong di chuyen
            Intent i = new Intent(Tuan23MainActivity.this, Tuan24MainActivity.class);
            // dua data vao
            i.putExtra("number1",tx1.getText().toString());
            i.putExtra("number2", tx2.getText().toString());
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