package com.example.waiternotes.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static int VERSION = 1;
    private static String NOME_DB = "waiterNotes";
    public static String TABELA_PRATOS = "pratos";
    public static String TABELA_PEDIDO = "pedidos";

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            String sqlPratos = "CREATE TABLE IF NOT EXISTS " + TABELA_PRATOS +
                    "(idPrato INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "descricao TEXT," +
                    "preco TEXT);";

            String sqlPedido = "CREATE TABLE IF NOT EXISTS " + TABELA_PEDIDO +
                    "(idPedido INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nomePrato TEXT," +
                    "garcom TEXT," +
                    "mesa TEXT);";

            db.execSQL(sqlPratos);
            db.execSQL(sqlPedido);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}