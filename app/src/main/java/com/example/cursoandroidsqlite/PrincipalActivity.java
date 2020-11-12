package com.example.cursoandroidsqlite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapters.AdapterDatos;

public class PrincipalActivity extends AppCompatActivity {

    ArrayList<String> listDatos;
    RecyclerView rcvUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rcvUsuarios = (RecyclerView)findViewById(R.id.rcvUsuarios);
        rcvUsuarios.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        listDatos = new ArrayList<String>();
        for (int i=0; i<=50; i++){
            listDatos.add("Datos usuarios "+i+" ");
        }

        AdapterDatos adaptador = new AdapterDatos(listDatos);
        rcvUsuarios.setAdapter(adaptador);
    }
}