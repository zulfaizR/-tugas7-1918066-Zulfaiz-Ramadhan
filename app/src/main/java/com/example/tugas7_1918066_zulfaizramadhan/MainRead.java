package com.example.tugas7_1918066_zulfaizramadhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<crypto> Listcrypto = new ArrayList<crypto>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, Listcrypto);
        mListView = (ListView) findViewById(R.id.list_crypto);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        Listcrypto.clear();
        List<crypto> crypto = db.ReadCrypto();
        for (crypto pr : crypto) {
            crypto daftar = new crypto();
            daftar.set_id(pr.get_id());
            daftar.set_jenis(pr.get_jenis());
            daftar.set_pengertian(pr.get_pengertian());
            Listcrypto.add(daftar);
            if ((Listcrypto.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        crypto   detailPr = (crypto) o;
        String Sid = detailPr.get_id();
        String Sjenis = detailPr.get_jenis();
        String Spengertian = detailPr.get_pengertian();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Ipengertian", Spengertian);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Listcrypto.clear();
        mListView.setAdapter(adapter_off);
        List<crypto> parfum = db.ReadCrypto();
        for (crypto pr : parfum) {
            crypto daftar = new crypto();
            daftar.set_id(pr.get_id());
            daftar.set_jenis(pr.get_jenis());
            daftar.set_pengertian(pr.get_pengertian());
            Listcrypto.add(daftar);
            if ((Listcrypto.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

