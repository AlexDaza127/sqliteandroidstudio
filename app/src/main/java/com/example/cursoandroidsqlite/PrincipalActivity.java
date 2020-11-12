package com.example.cursoandroidsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapters.AdapterDatos;
import entidades.UsuariosVo;
import openhelper.SQLiteBaseDatos;

public class PrincipalActivity extends AppCompatActivity {

    ArrayList<UsuariosVo> listDatos;
    RecyclerView rcvUsuarios;
    SQLiteBaseDatos helper = new SQLiteBaseDatos(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rcvUsuarios = (RecyclerView)findViewById(R.id.rcvUsuarios);
        rcvUsuarios.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        listDatos = new ArrayList<UsuariosVo>();

        //llenarUsuarios();
        consultarUsuarios();


        AdapterDatos adaptador = new AdapterDatos(listDatos);
        rcvUsuarios.setAdapter(adaptador);
    }

  /*  public void llenarUsuarios(){


        listDatos.add(new UsuariosVo(1,"Alex","Bogotá","Alex@gmail","aaaa"));
        listDatos.add(new UsuariosVo(2,"Alex","Bogotá","Alex@gmail","bbbb"));
        listDatos.add(new UsuariosVo(3,"Alex","Bogotá","Alex@gmail","cccc"));
        listDatos.add(new UsuariosVo(4,"Alex","Bogotá","Alex@gmail","dddd"));
    }*/

    public void consultarUsuarios(){
        SQLiteDatabase db = helper.getReadableDatabase();
        UsuariosVo usuario = null;
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);

        while(cursor.moveToNext()){
            usuario = new UsuariosVo();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setDistrito(cursor.getString(2));
            usuario.setCorreo(cursor.getString(3));
            usuario.setPassword(cursor.getString(4));

            listDatos.add(usuario);

        }
    }
}