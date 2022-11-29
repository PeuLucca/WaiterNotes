package com.example.waiternotes;

import java.io.Serializable;

public class PedidoModel implements Serializable {

    private Long idPedido;
    private String nomePrato;
    private String garcom;
    private String mesa;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getGarcom() {
        return garcom;
    }

    public void setGarcom(String garcom) {
        this.garcom = garcom;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
}