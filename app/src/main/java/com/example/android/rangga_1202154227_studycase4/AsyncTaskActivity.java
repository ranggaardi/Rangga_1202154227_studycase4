package com.example.android.rangga_1202154227_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AsyncTaskActivity extends AppCompatActivity {
    ListView listnm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task);
        listnm = (ListView) findViewById(R.id.listnama);
    }

    public void mulaiTask(View view) {
        new getData(listnm).execute();
    }
    class getData extends AsyncTask<String, Integer, String> {
        ListView listMahasiswa;
        ArrayAdapter adapter;
        ArrayList<String> listNama;
        ProgressDialog dialog;


        public getData(ListView listMhs) {
            this.listMahasiswa = listMhs;
            dialog = new ProgressDialog(AsyncTaskActivity.this);
            listNama = new ArrayList<>();
        }
        protected void onPreExecute() {
            super.onPreExecute();

            dialog.setTitle("Loading Data");
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            dialog.show();
        }
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>(AsyncTaskActivity.this, android.R.layout.simple_list_item_1, listNama);
            String[] mhs = {"Ali","Adi","Budi","Mamat","Wawan","Dodi","Didit","Jarwo","Sopo","Rudi","Gagah","Ribut","Yasin"};
            for (int a = 0; a < mhs.length; a++) {
                final long persen = 100L * a / mhs.length;
                final String nama = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen+"% - Adding "+nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listMahasiswa.setAdapter(adapter);
            dialog.dismiss();
        }
    }
}