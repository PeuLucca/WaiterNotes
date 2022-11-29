package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonCadastroPrato, buttonPedido, buttonListaPratos, btnListaPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastroPrato = findViewById(R.id.btnCadastroPrato);
        buttonPedido = findViewById(R.id.btnPedido);
        buttonListaPratos = findViewById(R.id.btnListaPratos);
        btnListaPedido = findViewById(R.id.btnListaPedido);

        buttonCadastroPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), CadastroPrato.class ) );
            }
        });

        buttonPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), CadastroPedido.class ) );
            }
        });

        buttonListaPratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), ListaPratos.class ) );
            }
        });

        btnListaPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), ListaPedidos.class ) );
            }
        });
    }
}