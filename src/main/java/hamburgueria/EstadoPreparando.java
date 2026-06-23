package hamburgueria;

/** [STATE] Estado concreto — pedido em preparo na cozinha. */
public class EstadoPreparando implements EstadoPedido {

    @Override
    public String receberPedido(PedidoContext pedido) {
        return "Erro: pedido #" + pedido.getNumero() + " já está sendo preparado.";
    }

    @Override
    public String prepararPedido(PedidoContext pedido) {
        return "Pedido #" + pedido.getNumero() + " já está na cozinha.";
    }

    @Override
    public String finalizarPedido(PedidoContext pedido) {
        pedido.setEstado(new EstadoPronto());
        return "Pedido #" + pedido.getNumero() + " pronto para entrega!";
    }

    @Override
    public String cancelarPedido(PedidoContext pedido) {
        return "Erro: pedido #" + pedido.getNumero() + " já está em preparo, não pode ser cancelado.";
    }

    @Override
    public String getNomeEstado() { return "Preparando"; }
}
