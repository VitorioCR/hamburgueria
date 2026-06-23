package hamburgueria;

/** [STATE] Estado concreto — pedido pronto, aguardando entrega. */
public class EstadoPronto implements EstadoPedido {

    @Override
    public String receberPedido(PedidoContext pedido) { return "Erro: pedido #" + pedido.getNumero() + " já está pronto."; }

    @Override
    public String prepararPedido(PedidoContext pedido) { return "Erro: pedido #" + pedido.getNumero() + " já foi preparado."; }

    @Override
    public String finalizarPedido(PedidoContext pedido) {
        pedido.setEstado(new EstadoEntregue());
        return "Pedido #" + pedido.getNumero() + " entregue ao cliente!";
    }

    @Override
    public String cancelarPedido(PedidoContext pedido) {
        return "Erro: pedido #" + pedido.getNumero() + " já está pronto, não pode ser cancelado.";
    }

    @Override
    public String getNomeEstado() { return "Pronto"; }
}
