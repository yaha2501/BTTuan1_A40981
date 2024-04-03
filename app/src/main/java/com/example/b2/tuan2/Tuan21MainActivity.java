package com.example.b2.tuan2;

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

public class Tuan21MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan21_main);
        tv = findViewById(R.id.Tuan2tv);
        // don data
        Intent i1 = getIntent();
        String str1 = Objects.requireNonNull(i1.getExtras()).getString("number1");
        String str2 = i1.getExtras().getString("number2");
        // convert String -> Float

        assert str1 != null;
        float fl1 = Float.parseFloat(str1);
        assert str2 != null;
        float fl2 = Float.parseFloat(str2);
        float tong = fl1+fl2;
        // hien thi ket qua
        tv.setText(String.valueOf(tong));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}