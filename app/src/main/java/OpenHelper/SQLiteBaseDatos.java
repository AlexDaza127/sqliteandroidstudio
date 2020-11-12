package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteBaseDatos extends SQLiteOpenHelper {
    public SQLiteBaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "" +
                "CREATE TABLE usuarios (" +
                "ID integer primary key autoincrementable, " +
                "Nombre text," +
                "Distrito text," +
                "Correo text," +
                "Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Método para abrir la base de datos

    public void abrir(){
        this.getWritableDatabase();
    }

    //Método para cerrar la base de datos

    public void cerrar(){
        this.close();
    }

    //Método que permite insertar registros en la tabla usuarios

    public void insertarReg(String nombre, String distrito, String correo, String password ){
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Distrito", distrito);
        valores.put("Correo", correo);
        valores.put("Password", password);

        this.getWritableDatabase().insert("usuarios",null, valores);

    }
}
