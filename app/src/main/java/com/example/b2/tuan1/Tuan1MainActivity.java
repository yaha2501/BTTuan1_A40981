package com.example.b2.tuan1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

public class Tuan1MainActivity extends AppCompatActivity {
    // khai bao control
    EditText txt1,txt2;
    Button btn;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan1_main);
        // anh xa cac control
        txt1 = findViewById(R.id.input1);
        txt2 = findViewById(R.id.input2);
        btn = findViewById(R.id.btn1);
        tv1 = findViewById(R.id.output);
        // xu ly event
        btn.setOnClickListener(v->{
            tinhTong(); // goi ham tinh tong
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void tinhTong() { // dinh nghia ham tinh tong
        String str1 = txt1.getText().toString(); // lấy dữ liệu nhập vào từ EditText1
        float number1 = Float.parseFloat(str1); // chuyển dữ liệu sang số
        String str2 = txt2.getText().toString();// lấy dữ liệu nhập vào từ EditText1
        float number2 = Float.parseFloat(str2); // chuyển dữ liệu sang số
        float tong = number1 + number2; // tính tổng
        tv1.setText(String.valueOf(tong)); // in kết quả vào id tv1
    }
}