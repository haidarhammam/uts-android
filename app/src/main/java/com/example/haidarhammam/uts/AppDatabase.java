package com.example.haidarhammam.uts;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.haidarhammam.uts.model.Kota;

@Database(entities = {Kota.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract KotaDAO kotaDAO();


}
