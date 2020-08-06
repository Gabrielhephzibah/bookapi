package com.cherish.bookapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookStoreAdapter extends ArrayAdapter<BookStoreList> {
    private Context mcontext;
    private List<BookStoreList> bookStoreLists;



    public BookStoreAdapter(@NonNull Context context, int resource ,List<BookStoreList>list) {
        super(context, 0,list) ;
        mcontext =context;
        bookStoreLists =list;
    }


    @NonNull
    @Override
    public View getView(int positon, @NonNull View convertView, @NonNull ViewGroup parent){
      View listItem = convertView;
      if (listItem == null) {
          listItem = LayoutInflater.from(mcontext).inflate(R.layout.book_layout, parent, false);
      }
      BookStoreList book = bookStoreLists.get(positon);
            TextView title = listItem.findViewById(R.id.title);
            title.setText(book.getTitle());

            TextView subTitle = listItem.findViewById(R.id.subTitle);
            subTitle.setText(book.getSubTitle());


            TextView price = listItem.findViewById(R.id.price);
            price.setText("" +book.getPrice());


            TextView isbn = listItem.findViewById(R.id.isbn);
            isbn.setText(book.getIsbn());

//             ImageView bookImage = listItem.findViewById(R.id.bookImage);
//             Picasso.get().load(book.getImageUrl()).into(bookImage);


             return listItem;


    }

//    @Override
//    public  int getCount(){
//        if (bookStoreLists.size() > 10){
//            return 10;
//        }else {
//            return bookStoreLists.size();
//        }
//    }


}

