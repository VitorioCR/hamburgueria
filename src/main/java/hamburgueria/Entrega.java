package hamburgueria;

/** [FACADE] Subsistema de entrega — despacha o pedido para o cliente. Singleton interno. */
public class Entrega extends Setor {

    private static Entrega entrega = new Entrega();
    private Entrega() {}

    public static Entrega getInstancia() { return entrega; }

    @Override
    public String processarPedido(int numeroPedido) {
        return "Entrega: despachando pedido #" + numeroPedido + " para o cliente";
    }
}
