package hamburgueria;

/** [COMMAND] Comando concreto — encapsula ação de preparar um pedido. */
public class PrepararPedido implements ComandoCozinha {

    private int numeroPedido;
    private String itens;

    public PrepararPedido(int numeroPedido, String itens) {
        this.numeroPedido = numeroPedido;
        this.itens = itens;
    }

    @Override
    public void executar() {
        System.out.println("Cozinha: iniciando preparo do pedido #" + numeroPedido + " | Itens: " + itens);
    }

    @Override
    public void desfazer() {
        System.out.println("Cozinha: cancelando preparo do pedido #" + numeroPedido);
    }

    public int getNumeroPedido() { return numeroPedido; }
    public String getItens() { return itens; }
}
