package hamburgueria;

/** [STATE] Estado concreto — pedido entregue, estado final. */
public class EstadoEntregue implements EstadoPedido {
    @Override public String receberPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " já foi entregue."; }
    @Override public String prepararPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " já foi entregue."; }
    @Override public String finalizarPedido(PedidoContext p) { return "Pedido #" + p.getNumero() + " já foi entregue."; }
    @Override public String cancelarPedido(PedidoContext p) { return "Erro: pedido #" + p.getNumero() + " já foi entregue, não pode ser cancelado."; }
    @Override public String getNomeEstado() { return "Entregue"; }
}
