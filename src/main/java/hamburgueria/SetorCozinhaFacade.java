package hamburgueria;

/** [FACADE] Subsistema de cozinha — prepara o pedido. Singleton interno. */
public class SetorCozinhaFacade extends Setor {

    private static SetorCozinhaFacade cozinha = new SetorCozinhaFacade();
    private SetorCozinhaFacade() {}

    public static SetorCozinhaFacade getInstancia() { return cozinha; }

    @Override
    public String processarPedido(int numeroPedido) {
        return "Cozinha: preparando pedido #" + numeroPedido;
    }
}
