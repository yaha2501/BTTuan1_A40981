package com.example.b2.Tuan3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

import java.util.ArrayList;

public class Tuan3ListviewMainActivity extends AppCompatActivity {
    ListView lv;
    // Tạo Adapter
    Tuan3Adapter adapter;
    ArrayList<Tuan3Contact> ls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan3_listview_main);
        lv = findViewById(R.id.Tuan3Listview);
        // tao nguon du lieu
        ls.add(new Tuan3Contact("Product 1","Use in home and work place ",R.drawable.hancock));
        ls.add(new Tuan3Contact("Product 2","Use in home and work place ",R.drawable.hp));
        ls.add(new Tuan3Contact("Product 3","Use in home and work place ",R.drawable.blogger));
        ls.add(new Tuan3Contact("Product 4","Use in home and work place ",R.drawable.chrome));
        ls.add(new Tuan3Contact("Product 5","Use in home and work place ",R.drawable.apple));
        ls.add(new Tuan3Contact("Product 6","Use in home and work place ",R.drawable.firefox));
        ls.add(new Tuan3Contact("Product 7","Use in home and work place ",R.drawable.firefox));
        ls.add(new Tuan3Contact("Product 7","Use in home and work place ",R.drawable.ic_launcher));
        ls.add(new Tuan3Contact("Product 7","Use in home and work place ",R.drawable.dell));
        ls.add(new Tuan3Contact("Product 7","Use in home and work place ",R.drawable.facebook));

        // Tao adapter
        adapter = new Tuan3Adapter(ls, this);
        lv.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
           return insets;
        });
    }
}