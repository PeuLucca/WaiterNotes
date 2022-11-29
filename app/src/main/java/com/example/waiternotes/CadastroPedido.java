package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waiternotes.helper.DaoPedido;
import com.example.waiternotes.helper.DaoPratos;

import java.util.ArrayList;
import java.util.List;

public class CadastroPedido extends AppCompatActivity {

    private EditText nomeGarcom, mesa;
    private Button btnCadastrarPedido;
    private RecyclerView recyclerView;

    private List<PratosModel> listaPratos = new ArrayList<>();
    String nomePratoSelectionado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        nomeGarcom = findViewById(R.id.editGarcom);
        mesa = findViewById(R.id.editMesa);
        btnCadastrarPedido = findViewById(R.id.btnCadastrarPedido);
        recyclerView = findViewById(R.id.recyclerViewPratos);

        carregarListaPratos();

        recyclerView.addOnItemTouchListener(new RecycleViewItemClickListener(getApplicationContext(), recyclerView, new RecycleViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                PratosModel pratos = listaPratos.get( position );
                Toast.makeText(getApplicationContext(),pratos.getNome(),
                        Toast.LENGTH_SHORT).show();
                nomePratoSelectionado = pratos.getNome();
            }
            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));

        btnCadastrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaoPedido daoPedido = new DaoPedido( getApplicationContext() );
                PedidoModel pedido = new PedidoModel();

                pedido.setNomePrato(nomePratoSelectionado);
                pedido.setGarcom(nomeGarcom.getText().toString());
                pedido.setMesa(mesa.getText().toString());

                if(nomePratoSelectionado.isEmpty() || nomeGarcom.getText().toString().isEmpty() ||
                        mesa.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"AVISO\nPreencha todos os campos",
                            Toast.LENGTH_SHORT).show();
                }else{
                    if(daoPedido.salvar( pedido )){
                        Toast.makeText(getApplicationContext(),"Pedido feito com sucesso",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Erro ao realizar pedido",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
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
            Toast.makeText(getApplicationContext(),"Nenhum foi prato cadastrado para que possa ser feito um pedido",
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