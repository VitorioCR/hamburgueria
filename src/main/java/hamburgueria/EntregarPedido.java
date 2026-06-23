package hamburgueria;

/** [COMMAND] Comando concreto — encapsula ação de entregar um pedido. */
public class EntregarPedido implements ComandoCozinha {

    private int numeroPedido;

    public EntregarPedido(int numeroPedido) { this.numeroPedido = numeroPedido; }

    @Override
    public void executar() {
        System.out.println("Entrega: despachando pedido #" + numeroPedido + " para o cliente");
    }

    @Override
    public void desfazer() {
        System.out.println("Entrega: revertendo despacho do pedido #" + numeroPedido);
    }
}
