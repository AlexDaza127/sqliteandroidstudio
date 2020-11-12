package com.example.cursoandroidsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import openhelper.SQLiteBaseDatos;

public class MainActivity extends AppCompatActivity {

    TextView txtRegistrese;
    Button btnIngresar;
    EditText edtUser,edtContra;
    SQLiteBaseDatos helper = new SQLiteBaseDatos(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRegistrese = (TextView)findViewById(R.id.txtRegistrese);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        edtUser = (EditText)findViewById(R.id.edtUser);
        edtContra = (EditText)findViewById(R.id.edtContra);

        txtRegistrese.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try{
                    Cursor consultarUsuario = helper.ConsultarUsuPass(edtUser.getText().toString(), edtContra.getText().toString());

                    if(consultarUsuario.getCount() > 0){
                        Intent i = new Intent(getApplicationContext(), PrincipalActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecto!", Toast.LENGTH_LONG).show();
                    }
                    edtUser.setText("");
                    edtContra.setText("");
                    edtUser.findFocus();

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
    }
}