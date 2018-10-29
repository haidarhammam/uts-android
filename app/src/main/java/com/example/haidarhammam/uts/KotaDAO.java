package com.example.haidarhammam.uts;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.haidarhammam.uts.model.Kota;

@Dao
public interface KotaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertKota(Kota kota);

    @Query("SELECT * FROM tkota")
    Kota[] selectAllKota();

}
