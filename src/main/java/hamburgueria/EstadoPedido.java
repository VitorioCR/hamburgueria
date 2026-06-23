package hamburgueria;

/** [STATE] Interface estado — define as transições possíveis de um pedido. */
public interface EstadoPedido {
    String receberPedido(PedidoContext pedido);
    String prepararPedido(PedidoContext pedido);
    String finalizarPedido(PedidoContext pedido);
    String cancelarPedido(PedidoContext pedido);
    String getNomeEstado();
}
