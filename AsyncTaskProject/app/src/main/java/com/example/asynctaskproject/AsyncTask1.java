package com.example.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class AsyncTask1 extends AsyncTask <Void, Void, String>{
    private WeakReference<ImageView> imageView;
    private WeakReference<TextView> tv;
    ImageView image;
    private Bitmap bitmap;
     AsyncTask1(ImageView image,TextView tv)
     {
        imageView= new WeakReference<>(image);
       this.tv= new WeakReference<>(tv);
       this.image=image;
       if(this.image==null)
       {
         Log.e("image","null");}



}

    @Override
    protected String doInBackground(Void... voids)
    {
        this.bitmap=doInBackground("https://a.c-dn.net/c/content/dam/publicsites/1511338782711/igcom/landing-sites/distilled/breakaway-currencies/images/maps/karnataka.png");

        return null;
    }

    protected Bitmap doInBackground(String... params) {
        Log.i("hello1", "hello1");
     //   publishProgress(1);
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
         //   publishProgress(0);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
   ImageView iv=(ImageView)imageView.get();
   if(iv!=null)
   {
       iv.setImageBitmap(this.bitmap);
   }
   this.image.setImageBitmap(this.bitmap);
        TextView textView=tv.get();
        textView.setText("loaded ....");
    }

    @Override
    protected void onPreExecute() {

         super.onPreExecute();
         TextView textView=tv.get();
         textView.setText("loading ....");
    }
}


