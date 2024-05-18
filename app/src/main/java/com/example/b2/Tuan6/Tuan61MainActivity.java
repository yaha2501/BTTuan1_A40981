package com.example.b2.Tuan6;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.b2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Tuan61MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProductAdapter adapter;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tuan61_main);
        listView = findViewById(R.id.Tuan61ListView);
        productList = new ArrayList<>();
        adapter = new ProductAdapter(this,productList);
        listView.setAdapter(adapter);
        // Get data from API
        new FetchProductsTask().execute();
    }
    private class FetchProductsTask extends AsyncTask<Void,Void,String>{//truyền vào hàm Void,k có tham số truyền vào, trả về kiểu string
        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder response = new StringBuilder(); // save result
            try{
                URL url = new URL("https://hungnttg.github.io/shopgiay.json");
                // open connection
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                // set method for read data
                connection.setRequestMethod("GET");
                // create buffer for read data
                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // read data
                String line="";
                while((line=reader.readLine())!=null){// đọc cho đến khi null
                    response.append(line);
                }
                reader.close(); // đọc xong thì đóng lại
            } catch (MalformedURLException e){
                throw new RuntimeException(e);
            } catch(IOException e){
                throw new RuntimeException(e);
            }
            return response.toString();// Return data for client
        }
        @Override
        protected void onPostExecute(String s){// ham tra data - client xử lý tiếp
            if(s!=null && !s.isEmpty()){
               try{
                   JSONObject json = new JSONObject(s);
                   JSONArray productsArray=json.getJSONArray("products");// get array for object
                   for (int i=0; i<productsArray.length(); i++){
                       JSONObject productObject=productsArray.getJSONObject(i);
                       String styleId = productObject.getString("styleid");
                       String brand=productObject.getString("brands_filter_facet");
                       String price=productObject.getString("price");
                       String info=productObject.getString("product_additional_info");
                       String searchImage=productObject.getString("search_image");
                       Product product=new Product(styleId,brand,price,info,searchImage);
                       productList.add(product);
                   }
                   adapter.notifyDataSetChanged();// update vào Adapter
               } catch (JSONException e) {
                   throw new RuntimeException(e);
               }
            }
            else {
                Toast.makeText(Tuan61MainActivity.this, "Failed to read data", Toast.LENGTH_LONG).show();
            }
        }
    }
}