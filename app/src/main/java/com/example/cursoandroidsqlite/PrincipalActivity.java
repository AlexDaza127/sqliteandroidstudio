package com.example.cursoandroidsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapters.AdapterDatos;
import entidades.UsuariosVo;
import openhelper.SQLiteBaseDatos;

public class PrincipalActivity extends AppCompatActivity {

    Button btnConsultarUser, btnMostrarTodos;
    EditText edtNomCon;
    ArrayList<UsuariosVo> listDatos;
    RecyclerView rcvUsuarios;
    SQLiteBaseDatos helper = new SQLiteBaseDatos(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rcvUsuarios = (RecyclerView)findViewById(R.id.rcvUsuarios);
        btnConsultarUser = (Button)findViewById(R.id.btnConsultarUser);
        btnMostrarTodos = (Button)findViewById(R.id.btnMostrarTodos);
        edtNomCon=(EditText)findViewById(R.id.edtNomCon);
        rcvUsuarios.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        listDatos = new ArrayList<UsuariosVo>();

        AdapterDatos adaptador = new AdapterDatos(listDatos);

        btnConsultarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarPorUser(edtNomCon.getText().toString());
            }
        });

        btnMostrarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarUsuarios();
            }
        });

        adaptador.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "Selección: " + listDatos.get(rcvUsuarios.getChildAdapterPosition(v)).getNombre(),
                        Toast.LENGTH_LONG).show();
            }
        });

        rcvUsuarios.setAdapter(adaptador);
    }

    public void consultarUsuarios(){
        helper.abrir();
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
        helper.cerrar();
    }

    public void consultarPorUser(String id){
        helper.abrir();
        SQLiteDatabase db = helper.getReadableDatabase();
        UsuariosVo usuario = null;
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE ID = "+id+"", null);

        while(cursor.moveToNext()){
            usuario = new UsuariosVo();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setDistrito(cursor.getString(2));
            usuario.setCorreo(cursor.getString(3));
            usuario.setPassword(cursor.getString(4));

            listDatos.add(usuario);
        }
        helper.cerrar();
    }


}