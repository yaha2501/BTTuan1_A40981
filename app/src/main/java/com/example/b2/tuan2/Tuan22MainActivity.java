package com.example.b2.tuan2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

public class Tuan22MainActivity extends AppCompatActivity {
    ListView lv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan22_main);
        lv = findViewById(R.id.Tuan22ListView);
        // nguon data
        String [] arr = new String[]{"Week 1","Week 2","Week 3","Week 4","Week 5","Week 6","Week 7","Week 8","Week 9","Week 10"};
        // adapter
        ArrayAdapter<String>
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        // adapter: 1(được sử dụng cho cái nào), 2(giao diện sử dung), 3(nguồn dữ liệu)
        // show on listview
        lv.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}