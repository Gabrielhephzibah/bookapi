package com.cherish.bookapi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.model.Progress;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    BookStoreAdapter bookStoreAdapter;
    List<BookStoreList> bookStore = new ArrayList<>();
    ListView listView;
    //    List<BookStoreList> list;
    BookStoreList book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AndroidNetworking.initialize(getApplicationContext());
        listView = findViewById(R.id.listView);
        loading();


    }

    public void loading() {
        AndroidNetworking.get("https://api.itbook.store/1.0/new")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("RESPONSE","SUCCESSFUL");
                        if (response!=null){
                            try {
                                JSONArray array = response.getJSONArray("books");
                                for (int i = 0; i < array.length(); i++){
                                    JSONObject jsonObject = array.getJSONObject(i);
                                    BookStoreList bookStoreList = new BookStoreList();
                                    bookStoreList.setTitle(jsonObject.getString("title"));
                                    bookStoreList.setSubTitle(jsonObject.getString("subtitle"));
                                    bookStoreList.setPrice(jsonObject.getString("price"));
                                    bookStoreList.setIsbn(jsonObject.getString("isbn13"));
                                    bookStore.add(bookStoreList);
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            bookStoreAdapter = new BookStoreAdapter(MainActivity.this,0, bookStore);



                            listView.setAdapter(bookStoreAdapter);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("ERROR", "ERROR");
                    }

//
//        AndroidNetworking.get("https://api.itbook.store/1.0/new")
////                .addPathParameter("pageNumber", "0")
////                .addQueryParameter("limit", "3")
////                .addHeaders("token", "1234")
////                .setTag("test")
//                .setTag("test")
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONArray(new JSONArrayRequestListener() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.d("RESPONSE", String.valueOf(response));
//                        // do anything with response
////                        if (response != null){
////                            Log.d("RESPONSE", String.valueOf(response));
////                            bookStoreLists = new ArrayList<>();
////                            for (int i = 0; i<response.length();i++){
////                                try {
////
////                                    JSONObject jsonObject = response.getJSONObject(i);
////                                    book.setTitle(jsonObject.getString("title"));
////                                    book.setSubTitle(jsonObject.getString("subtitle"));
////                                    book.setIsbn(jsonObject.getString("isbn"));
////                                    book.setPrice(jsonObject.getString("price"));
////                                    bookStoreLists.add(book);
////
////
////
////                                }catch (JSONException e){
////                                        e.printStackTrace();
////
////                                }
////                                bookStoreAdapter = new BookStoreAdapter(MainActivity.this,0,bookStoreLists);
////                                listView.setAdapter(bookStoreAdapter);
////
////
////
////                            }
////
////                        }
//                    }
//                    @Override
//                    public void onError(ANError error) {
//                        Log.d("ERROR",error.getErrorDetail());
//                        Log.d("ERROR2",String.valueOf(error.getResponse()));
//                        // handle error
////                        System.out.println(error.getMessage());
////                        Log.i("Error Message", error.getMessage());
//                    }
//                });
//        final ProgressDialog dialog = Utils.showProgressDialog(MainActivity.this,"LOADING......");
//        dialog.show();

//
//        AndroidNetworking.get("https://api.itbook.store/1.0/new")
////                .setTag(this)
////                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // do anything with response
//                        if (response!= null){
////                            bookStoreLists = new ArrayList<>();
//
//
//                            JSONArray jsonArray = new JSONArray();
//                            jsonArray.put(response);
//                            for (int i = 0; i < jsonArray.length(); i++){
//                                try {
//                                    Log.i("message",jsonArray.toString());
//                                   String title = jsonArray.getJSONObject(i).getString("title");
////                                    String subtitle = jsonArray.getJSONObject(i).getString("subtitle");
//////                                    String imageUrl = jsonArray.getJSONObject(i).getString("image");
////                                    double bookPrice = Double.parseDouble(jsonArray.getJSONObject(i).getString("price"));
////                                    int isbn = Integer.parseInt(jsonArray.getJSONObject(i).getString("image"));
//                                    bookStoreLists.add( new BookStoreList(title));
////
//                                }catch (Exception e){
//                                    e.printStackTrace();
//                                }
//
//
//                            }
//
//                            bookStoreAdapter = new BookStoreAdapter(MainActivity.this,bookStoreLists);
//                            listView.setAdapter(bookStoreAdapter);


//                            JSONArray jsonarray;
//                            try {
//                                BookStoreList model = new BookStoreList();
//                                jsonarray = new JSONArray(response);
//                                for (int i = 0; i < jsonarray.length(); i++) {
//                                    JSONObject JsonObject = jsonarray.optJSONObject(i);
//                                    model.setTitle(JsonObject .getString("title"));
//                                    list.add(model);
//                                    bookStoreAdapter = new BookStoreAdapter(MainActivity.this, list);
//                                listView.setAdapter(bookStoreAdapter);
//
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }

//                            for (int i = 0; i < response.length(); i++){
//
//                                try {
//                                    BookStoreList model = new BookStoreList();
//                                    JSONObject jsonObject = response.getJSONObject(String.valueOf(i));
//                                    model.setTitle(jsonObject.getString("title"));
//                                    model.setSubTitle(jsonObject.getString("subtitle"));
//                                    model.setIsbn(jsonObject.getInt("isbn"));
//                                    model.setPrice(jsonObject.getDouble("price"));
////                                    model.setImageUrl(jsonObject.getString("image"));
//
//                                    list.add(model);
////                                    dialog.dismiss();
//                                }catch (Exception e){
//                                    e.printStackTrace();
//
//                                }
//                                bookStoreAdapter = new BookStoreAdapter(MainActivity.this, list);
//                                listView.setAdapter(bookStoreAdapter);
//
////                            }
//                        }
//                    }
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                        System.out.println(error.getMessage());
//                        Log.i("Error Message", error.getMessage());
////                        dialog.dismiss();
//                    }
//                });

                });
    }
}
