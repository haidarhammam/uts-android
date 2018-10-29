package com.example.haidarhammam.uts;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haidarhammam.uts.model.Kota;

public class DBKotaActivity extends AppCompatActivity {

    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "kotadb").build();

        final EditText edtNamaKota = findViewById(R.id.txtKota);
        Button btnSimpan = findViewById(R.id.btnSimpan);
        Button btnCek = findViewById(R.id.btnCek);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kota kota = new Kota();
                kota.setNama(edtNamaKota.getText().toString());
                insertData(kota);
            }
        });

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ReadActivity.getActIntent(DBKotaActivity.this));
            }
        });
    }

    private void insertData(final Kota kota){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.kotaDAO().insertKota(kota);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(DBKotaActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}
