package com.example.waiternotes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterListaPratos extends RecyclerView.Adapter<AdapterListaPratos.MyViewHolder>{

    private List<PratosModel> listaPratos;
    private PratosModel pratosModel = new PratosModel();
    private Context context;
    private RecyclerView recyclerView;

    public AdapterListaPratos(List<PratosModel> listaPratosModel,Context context,RecyclerView recyclerView) {
        this.listaPratos = listaPratosModel;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_adapter_lista_pratos,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PratosModel pratos = listaPratos.get( position );
        holder.nome.setText( pratos.getNome() );
        holder.descricao.setText( pratos.getDescricao() );
        holder.preco.setText( pratos.getPreco() );
    }

    @Override
    public int getItemCount() {
        return this.listaPratos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nome,preco,descricao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomePrato);
            preco = itemView.findViewById(R.id.txtPreco);
            descricao = itemView.findViewById(R.id.txtDescricao);

        }
    }

}