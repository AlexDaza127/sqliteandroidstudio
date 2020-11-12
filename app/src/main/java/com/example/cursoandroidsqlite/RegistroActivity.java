package com.example.cursoandroidsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import openhelper.SQLiteBaseDatos;

public class RegistroActivity extends AppCompatActivity {

    Button btnRegistrar;
    EditText edtNombre, edtDistrito, edtCorreo, edtPass;

    SQLiteBaseDatos helper = new SQLiteBaseDatos(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDistrito = (EditText) findViewById(R.id.edtDistrito);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        edtPass = (EditText) findViewById(R.id.edtPass);

    btnRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            helper.abrir();
            helper.insertarReg(
                    String.valueOf(edtNombre.getText()),
                    String.valueOf(edtDistrito.getText()),
                    String.valueOf(edtCorreo.getText()),
                    String.valueOf(edtPass.getText()));
            helper.cerrar();

            Toast.makeText(getApplicationContext(), "Registro Almacenado con Exito!", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }
    });

    }
}