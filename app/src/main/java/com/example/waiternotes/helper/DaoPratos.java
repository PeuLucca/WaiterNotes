package com.example.waiternotes.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaDrm;

import com.example.waiternotes.PratosModel;

import java.util.ArrayList;
import java.util.List;


public class DaoPratos{

    private SQLiteDatabase escreve,le;
    private Cursor cursor;

    public DaoPratos(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    public boolean salvar(PratosModel pratos) {

        ContentValues cv = new ContentValues();
        cv.put( "nome" , pratos.getNome() );
        cv.put( "descricao" , pratos.getDescricao() );
        cv.put( "preco" , pratos.getPreco() );

        try{
            escreve.insert( DbHelper.TABELA_PRATOS , null, cv );
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean atualizar(PratosModel pratos) {

        ContentValues cv = new ContentValues();
        cv.put( "nome" , pratos.getNome() );
        cv.put( "descricao" , pratos.getDescricao() );
        cv.put( "preco" , pratos.getPreco() );

        try{

            String[] args = { pratos.getIdPrato().toString() };
            escreve.update( DbHelper.TABELA_PRATOS, cv, "idPrato=?", args );

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean deletar(PratosModel pratos) {

        String[] args = { pratos.getIdPrato().toString() };

        try {
            escreve.delete(DbHelper.TABELA_PRATOS,"idPrato=?",args);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public List<PratosModel> listar() {

        List<PratosModel> pratosList = new ArrayList<>();

        String sqlListar = "SELECT * FROM pratos ORDER BY nome;";
        cursor = le.rawQuery( sqlListar, null );

        while(cursor.moveToNext()){

            PratosModel pratos = new PratosModel();

            @SuppressLint("Range") Long id = cursor.getLong( cursor.getColumnIndex("idPrato") );
            @SuppressLint("Range") String nome = cursor.getString( cursor.getColumnIndex( "nome" ) );
            @SuppressLint("Range") String descricao = cursor.getString( cursor.getColumnIndex( "descricao" ) );
            @SuppressLint("Range") String preco = cursor.getString( cursor.getColumnIndex( "preco" ) );

            pratos.setIdPrato( id );
            pratos.setNome( nome );
            pratos.setDescricao( descricao );
            pratos.setPreco( preco );

            pratosList.add( pratos );
        }

        return pratosList;
    }
}