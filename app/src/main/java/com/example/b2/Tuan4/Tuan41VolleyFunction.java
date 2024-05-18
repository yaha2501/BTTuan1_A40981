package com.example.b2.Tuan4;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tuan41VolleyFunction {
    String strJson = "";
    public void getJsonArrayObject(Context context, TextView textview){
        //1. Tao Request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2. URL
        String url = "https://hungnttg.github.io/array_json_new.json"; // link json format
        //3. Goi Request
        //JsonArrayRequest(url, thanh cong, that bai)
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        // chuyen mang -> doi tuong
                        for (int i=0;  i<jsonArray.length(); i++){
                            try{
                                // lay ra tung phan tu trong mang
                                JSONObject person = jsonArray.getJSONObject(i);
                                // boc ra thanh tung chuoi String
                                String id = person.getString("id");// lay ve id
                                String name = person.getString("name");
                                String email = person.getString("email");
                                String address = person.getString("address");
//                                String gender = person.getString("gender");
//                                String profile_pic = person.getString("profile");

                                // noi cac chuoi tren
                                strJson += "Id: "+id+"\n";
                                strJson += "Name: "+name+"\n";
                                strJson += "Email: "+email+"\n";
                                strJson += "Address: "+address+"\n";
//                                strJson += "Gender: "+gender+"\n";
//                                strJson += "Profile: "+profile_pic+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            // sau khi noi xong ta se dua het vao
                            textview.setText(strJson);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               textview.setText(volleyError.getMessage());
            }
        });
        //4. Thuc thi request
        queue.add(request); // add request

    }
}
