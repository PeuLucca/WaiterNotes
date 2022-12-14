package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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
        carregarListaPratos();
        super.onStart();
    }

    public void carregarListaPratos(){

        DaoPratos dao = new DaoPratos(getApplicationContext());
        listaPratos = dao.listar();

        if(listaPratos.isEmpty()){
            Toast.makeText(getApplicationContext(),"Nenhum prato cadastrado",
                    Toast.LENGTH_SHORT).show();
        }

        AdapterListaPratos adapter = new AdapterListaPratos(listaPratos,getApplicationContext(),recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

}