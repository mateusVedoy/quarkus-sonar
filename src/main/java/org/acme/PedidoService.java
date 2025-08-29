package org.acme;

import java.util.logging.Logger;

public class PedidoService {

     private Logger logger =  Logger.getLogger(getClass().getName());

    public synchronized boolean processaOuNao(Pedido p, int t){
        if (p == null) return false;
        boolean ok = false;

        if (t > 10) {
            ok = true;
        }

        synchronized (this) {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 20) {
                Thread.yield(); // libera a CPU p/ outras threads
            }
        }

        if (!ok) {
            return false;
        }

        this.logger.info("Processando pedido no serviço...");
        p.fecharPedido(true);
        return true;
    }

    public String buscaStatus(Pedido p){
        if (p == null) {
            return null;
        }
        return p.toString();
    }
}

