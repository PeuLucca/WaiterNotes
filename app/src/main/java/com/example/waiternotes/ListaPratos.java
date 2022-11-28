package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.waiternotes.helper.DaoPratos;

import java.util.ArrayList;
import java.util.List;

public class ListaPratos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PratosModel> listaPratos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pratos);

        recyclerView = findViewById(R.id.recyclerVIewListaPratos);
    }

    @Override
    protected void onStart() {
        carregarListaClientes();
        super.onStart();
    }

    public void carregarListaClientes(){

        DaoPratos dao = new DaoPratos(getApplicationContext());
        listaPratos = dao.listar();

        AdapterListaPratos adapter = new AdapterListaPratos(listaPratos,getApplicationContext(),recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

}