package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/**
 * [FACADE] Fachada principal — interface simplificada que orquestra SetorCaixa, SetorCozinhaFacade
 * e Entrega internamente. O cliente chama apenas realizarPedido().
 */
public class PedidoFacade {

    private SetorCozinhaFacade cozinha;
    private SetorCaixa caixa;
    private Entrega entrega;

    public PedidoFacade() {
        this.cozinha = SetorCozinhaFacade.getInstancia();
        this.caixa = SetorCaixa.getInstancia();
        this.entrega = Entrega.getInstancia();
    }

    public List<String> realizarPedido(int numeroPedido) {
        List<String> resultados = new ArrayList<>();
        resultados.add(caixa.processarPedido(numeroPedido));
        resultados.add(cozinha.processarPedido(numeroPedido));
        resultados.add(entrega.processarPedido(numeroPedido));
        return resultados;
    }

    public boolean verificarPendencias(int numeroPedido) {
        return cozinha.verificarPedidoComPendencia(numeroPedido)
                || caixa.verificarPedidoComPendencia(numeroPedido)
                || entrega.verificarPedidoComPendencia(numeroPedido);
    }
}
