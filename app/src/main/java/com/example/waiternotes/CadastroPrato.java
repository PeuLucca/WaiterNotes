package com.example.waiternotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waiternotes.helper.DaoPratos;

public class CadastroPrato extends AppCompatActivity {

    private EditText nomePrato, descricao, preco;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_prato);

        nomePrato = findViewById(R.id.editNomePrato);
        descricao = findViewById(R.id.editDescricao);
        preco = findViewById(R.id.editPreco);
        btnCadastrar = findViewById(R.id.btnCadastrarPrato);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaoPratos daoPratos = new DaoPratos( getApplicationContext() );
                PratosModel pratos = new PratosModel();

                pratos.setNome(nomePrato.getText().toString());
                pratos.setDescricao(descricao.getText().toString());
                pratos.setPreco(preco.getText().toString());

                if(nomePrato.getText().toString().isEmpty() || descricao.getText().toString().isEmpty() ||
                        preco.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"AVISO\nPreencha todos os campos",
                            Toast.LENGTH_SHORT).show();
                }else{
                    if(daoPratos.salvar( pratos )){
                        Toast.makeText(getApplicationContext(),"Prato cadastrado com sucesso",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Erro ao cadastrar prato",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}