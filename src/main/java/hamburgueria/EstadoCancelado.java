package hamburgueria;

/** [STATE] Estado concreto — pedido cancelado, estado final. */
public class EstadoCancelado implements EstadoPedido {
    @Override public String receberPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " foi cancelado."; }
    @Override public String prepararPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " foi cancelado."; }
    @Override public String finalizarPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " foi cancelado."; }
    @Override public String cancelarPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " já está cancelado."; }
    @Override public String getNomeEstado() { return "Cancelado"; }
}
