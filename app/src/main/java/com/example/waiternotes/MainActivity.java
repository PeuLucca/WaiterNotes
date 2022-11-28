package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonCadastroPrato, buttonPedido, buttonListaPratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastroPrato = findViewById(R.id.btnCadastroPrato);
        buttonPedido = findViewById(R.id.btnPedido);
        buttonListaPratos = findViewById(R.id.btnListaPratos);

        buttonCadastroPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), CadastroPrato.class ) );
            }
        });

        buttonPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Botao Pedido clicado", Toast.LENGTH_SHORT).show();
            }
        });

        buttonListaPratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(), ListaPratos.class ) );
            }
        });
    }
}