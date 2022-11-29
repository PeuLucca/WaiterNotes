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


public class AdapterListaPedidos extends RecyclerView.Adapter<AdapterListaPedidos.MyViewHolder>{

    private List<PedidoModel> listaPedido;
    private PedidoModel pedidoModel = new PedidoModel();
    private Context context;
    private RecyclerView recyclerView;

    public AdapterListaPedidos(List<PedidoModel> listaPedidoModel,Context context,RecyclerView recyclerView) {
        this.listaPedido = listaPedidoModel;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_adapter_lista_pedidos,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PedidoModel pedido = listaPedido.get( position );
        holder.nome.setText( pedido.getNomePrato() );
        holder.garcom.setText( "Garçom: " + pedido.getGarcom() );
        holder.mesa.setText( "Mesa: " + pedido.getMesa() );
    }

    @Override
    public int getItemCount() {
        return this.listaPedido.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nome,garcom,mesa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomePrato_adapter);
            garcom = itemView.findViewById(R.id.txtNomeGarcom_adapter);
            mesa = itemView.findViewById(R.id.txtMesa_adapter);

        }
    }

}