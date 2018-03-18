package com.example.android.rangga_1202154227_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

public class CariGambarActivity extends AppCompatActivity {
    ImageView gambar;
    EditText cariLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_gambar);

        gambar = (ImageView)findViewById(R.id.img);
        cariLink = (EditText)findViewById(R.id.cari);

    }
    public void CariGambar(View view){
        new tampilGambar().execute();
    }
    class tampilGambar extends AsyncTask<Void, Void, Bitmap> {
        protected Bitmap doInBackground(Void... voids) {

            String link = cariLink.getText().toString();

            Bitmap map = null;
            try {

                map = BitmapFactory.decodeStream((InputStream)new URL(link).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return map;
        }
        protected void onPostExecute(Bitmap bitmap) {
            gambar.setImageBitmap(bitmap);
        }
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }
}
