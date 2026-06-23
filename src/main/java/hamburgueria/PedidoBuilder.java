package hamburgueria;

import java.util.List;

/** [BUILDER] Constrói objetos Pedido passo-a-passo, garantindo consistência e fluência. */
public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public Pedido build() {
        if (pedido.getNumero() == 0) {
            throw new IllegalArgumentException("Número do pedido inválido");
        }
        if (pedido.getNomeCliente().equals("")) {
            throw new IllegalArgumentException("Nome do cliente inválido");
        }
        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido sem itens");
        }
        return pedido;
    }

    public PedidoBuilder setNumero(int numero) { pedido.setNumero(numero); return this; }
    public PedidoBuilder setNomeCliente(String nomeCliente) { pedido.setNomeCliente(nomeCliente); return this; }
    public PedidoBuilder setObservacoes(String observacoes) { pedido.setObservacoes(observacoes); return this; }
    public PedidoBuilder setEnderecoEntrega(String enderecoEntrega) { pedido.setEnderecoEntrega(enderecoEntrega); return this; }
    public PedidoBuilder setFormaPagamento(String formaPagamento) { pedido.setFormaPagamento(formaPagamento); return this; }
    public PedidoBuilder setItens(List<String> itens) { pedido.setItens(itens); return this; }
    public PedidoBuilder addItem(String item) { pedido.getItens().add(item); return this; }
    public PedidoBuilder setParaViagem(boolean paraViagem) { pedido.setParaViagem(paraViagem); return this; }
}
