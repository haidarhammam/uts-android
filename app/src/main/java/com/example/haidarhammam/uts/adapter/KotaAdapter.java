package com.example.haidarhammam.uts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.haidarhammam.uts.AppDatabase;
import com.example.haidarhammam.uts.R;
import com.example.haidarhammam.uts.model.Kota;

import java.util.ArrayList;


public class KotaAdapter extends RecyclerView.Adapter<KotaAdapter.KotaViewHolder> {
    private ArrayList<Kota> daftarKota;
    private Context context;
    private AppDatabase db;

    public KotaAdapter(ArrayList<Kota> dataset){
        this.daftarKota = dataset;
    }

    public KotaAdapter(ArrayList<Kota> kotas, Context ctx){
        this.daftarKota = kotas;
        this.context = ctx;
    }
    @NonNull
    @Override
    public KotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_kota, parent, false);
        KotaViewHolder kotaViewHolder = new KotaViewHolder(view);
        return kotaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KotaViewHolder holder, final int position) {
        final String nama = daftarKota.get(position).getNama();
        holder.txtNama.setText(nama);
    }

    @Override
    public int getItemCount() {
        return daftarKota.size();
    }

    public class KotaViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNama;
        public KotaViewHolder(View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.nama);
        }
    }
}

