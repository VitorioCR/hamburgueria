package hamburgueria;

/** [STATE] Estado concreto — pedido recém-recebido, aguardando preparo. */
public class EstadoRecebido implements EstadoPedido {

    @Override
    public String receberPedido(PedidoContext pedido) {
        return "Pedido #" + pedido.getNumero() + " já foi recebido.";
    }

    @Override
    public String prepararPedido(PedidoContext pedido) {
        pedido.setEstado(new EstadoPreparando());
        return "Pedido #" + pedido.getNumero() + " enviado para a cozinha.";
    }

    @Override
    public String finalizarPedido(PedidoContext pedido) {
        return "Erro: pedido #" + pedido.getNumero() + " ainda não foi preparado.";
    }

    @Override
    public String cancelarPedido(PedidoContext pedido) {
        pedido.setEstado(new EstadoCancelado());
        return "Pedido #" + pedido.getNumero() + " cancelado com sucesso.";
    }

    @Override
    public String getNomeEstado() { return "Recebido"; }
}
