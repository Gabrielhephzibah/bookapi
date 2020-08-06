package com.cherish.bookapi;

import android.app.ProgressDialog;
import android.content.Context;

import com.androidnetworking.model.Progress;

public class Utils {
    public  static ProgressDialog showProgressDialog(Context context, String message ){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setTitle(null);

        return dialog;

    }
}
