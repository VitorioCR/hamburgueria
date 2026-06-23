package hamburgueria;

import java.util.List;

/**
 * [PROXY] Proxy de proteção + lazy loading — controla acesso a PedidoReal.
 * - obterResumo(): lazy load sem restrição
 * - obterDetalhesPagamento(): verifica se Gerente é admin antes de liberar
 */
public class PedidoProxy implements IPedido {

    private PedidoReal pedido;
    private Integer numero;

    public PedidoProxy(Integer numero) { this.numero = numero; }

    @Override
    public List<String> obterResumo() {
        if (this.pedido == null) this.pedido = new PedidoReal(this.numero);
        return this.pedido.obterResumo();
    }

    @Override
    public List<String> obterDetalhesPagamento(Gerente gerente) {
        if (!gerente.isAdministrador()) {
            throw new IllegalArgumentException("Gerente não autorizado a ver detalhes de pagamento");
        }
        if (this.pedido == null) this.pedido = new PedidoReal(this.numero);
        return this.pedido.obterDetalhesPagamento(gerente);
    }
}
