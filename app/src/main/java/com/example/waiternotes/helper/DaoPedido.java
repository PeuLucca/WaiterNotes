package com.example.waiternotes.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaDrm;

import com.example.waiternotes.PedidoModel;
import com.example.waiternotes.PratosModel;

import java.util.ArrayList;
import java.util.List;


public class DaoPedido{

    private SQLiteDatabase escreve,le;
    private Cursor cursor;

    public DaoPedido(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    public boolean salvar(PedidoModel pedido) {

        ContentValues cv = new ContentValues();
        cv.put( "nomePrato" , pedido.getNomePrato() );
        cv.put( "garcom" , pedido.getGarcom() );
        cv.put( "mesa" , pedido.getMesa() );

        try{
            escreve.insert( DbHelper.TABELA_PEDIDO , null, cv );
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


    public List<PedidoModel> listar() {

        List<PedidoModel> pedidoModelList = new ArrayList<>();

        String sqlListar = "SELECT * FROM pedidos ORDER BY nomePrato;";
        cursor = le.rawQuery( sqlListar, null );

        while(cursor.moveToNext()){

            PedidoModel pedido = new PedidoModel();

            @SuppressLint("Range") Long id = cursor.getLong( cursor.getColumnIndex("idPedido") );
            @SuppressLint("Range") String nomePrato = cursor.getString( cursor.getColumnIndex( "nomePrato" ) );
            @SuppressLint("Range") String garcom = cursor.getString( cursor.getColumnIndex( "garcom" ) );
            @SuppressLint("Range") String mesa = cursor.getString( cursor.getColumnIndex( "mesa" ) );

            pedido.setIdPedido( id );
            pedido.setNomePrato( nomePrato );
            pedido.setGarcom( garcom );
            pedido.setMesa( mesa );

            pedidoModelList.add( pedido );
        }

        return pedidoModelList;
    }
}