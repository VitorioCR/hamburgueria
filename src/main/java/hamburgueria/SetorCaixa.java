package hamburgueria;

/** [FACADE] Subsistema de caixa — processa pagamento do pedido. Singleton interno. */
public class SetorCaixa extends Setor {

    private static SetorCaixa caixa = new SetorCaixa();
    private SetorCaixa() {}

    public static SetorCaixa getInstancia() { return caixa; }

    @Override
    public String processarPedido(int numeroPedido) {
        return "Caixa: processando pagamento do pedido #" + numeroPedido;
    }
}
