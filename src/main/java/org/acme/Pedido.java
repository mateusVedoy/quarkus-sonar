package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private List<String> itens = new ArrayList<>();
    private double valorTotal;
    private String status = "NOVO";
    private static final String STATE_PROCESSING = "PROCESSANDO";
    private Logger logger =  Logger.getLogger(getClass().getName());

    public void adicionarItem(String nome, double preco){
        if (nome == null || nome.isEmpty()) {
           this.logger.info("Item sem nome");
        }
        itens.add(nome);
        valorTotal += preco;
        if (valorTotal > 1000) {  this.logger.info("Pedido grande!"); }
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder("Pedido: ");
        for (int i = 0; i < itens.size(); i++) {
            sb.append(itens.get(i));
            if (i < itens.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void processar(){
        if ("NOVO".equals(status)) {
             this.logger.info("Processando pedido novo...");
            status = STATE_PROCESSING;
        }
        if (STATE_PROCESSING.equals(status)) {
             this.logger.info("Ainda processando...");
        }

        int tipo = 2;

        if (tipo == 2)
            this.logger.info("Tipo 2"); 

        try {
            if (valorTotal < 0) throw new IllegalStateException("valor negativo?");
        } catch (Exception e) {
            this.logger.warning(e.getMessage());
        }
    }

    public void fecharPedido(boolean notificarCliente){
        if (!STATE_PROCESSING.equals(status)) {  this.logger.info("Estado inválido"); }
        status = "FECHADO";
        if (notificarCliente) {
             this.logger.info("Notificando cliente...");
        }
    }
}

