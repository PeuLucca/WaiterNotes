package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.waiternotes.helper.DaoPedido;
import com.example.waiternotes.helper.DaoPratos;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<PedidoModel> listaPedidos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);

        recyclerView = findViewById(R.id.recyclerListaPratos);
    }

    @Override
    protected void onStart() {
        carregarListaPedidos();
        super.onStart();
    }

    public void carregarListaPedidos(){

        DaoPedido dao = new DaoPedido(getApplicationContext());
        listaPedidos = dao.listar();

        if(listaPedidos.isEmpty()){
            Toast.makeText(getApplicationContext(),"Nenhum pedido cadastrado",
                    Toast.LENGTH_SHORT).show();
        }

        AdapterListaPedidos adapter = new AdapterListaPedidos(listaPedidos,getApplicationContext(),recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}