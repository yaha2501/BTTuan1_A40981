package com.example.b2.Tuan3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

import java.util.Objects;

public class Tuan32MainActivity extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan32_main);
        tv1 = findViewById(R.id.Tuan32Textview1);
        Intent it = getIntent();
        int hsA = Integer.parseInt(Objects.requireNonNull(Objects.requireNonNull(it.getExtras()).getString("a")));
        int hsB = Integer.parseInt(Objects.requireNonNull(it.getExtras().getString("b")));
        int hsC = Integer.parseInt(Objects.requireNonNull(it.getExtras().getString("c")));
        float delta = hsA*hsB - 4*hsA*hsC;
        if (delta<0){
            tv1.setText("Phương trình vô nghiệm !");
        }
        else if (delta==0){
            tv1.setText("Phương trình có nghiệm kép là :  "+(-hsB)/(2*hsA));
        }
        else {
            float x1 = (float) (-hsB+Math.sqrt(delta))/(2*hsA);
            float x2 = (float) (-hsB-Math.sqrt(delta))/(2*hsA);
            tv1.setText("Phương trình có 2 nghiệm là x1 = "+x1+" và x2 = "+x2 );

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}