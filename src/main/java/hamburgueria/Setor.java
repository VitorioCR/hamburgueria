package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [FACADE] Setor interno do restaurante — base para Caixa, Cozinha e Entrega usados pela Fachada. */
public abstract class Setor {

    private List<Integer> pedidosComPendencia = new ArrayList<>();

    public void adicionarPedidoPendente(int numeroPedido) {
        this.pedidosComPendencia.add(numeroPedido);
    }

    public boolean verificarPedidoComPendencia(int numeroPedido) {
        return this.pedidosComPendencia.contains(numeroPedido);
    }

    public abstract String processarPedido(int numeroPedido);
}
