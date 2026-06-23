package hamburgueria;

/** [CHAIN OF RESPONSIBILITY] Handler abstrato — define a cadeia de validadores. */
public abstract class ValidadorPedido {

    protected ValidadorPedido proximo;

    public ValidadorPedido setProximo(ValidadorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract String validar(SolicitacaoPedido solicitacao);

    protected boolean podeValidar(SolicitacaoPedido solicitacao) {
        return this.getTipoValidacao() == solicitacao.getTipoValidacao();
    }

    protected abstract TipoValidacao getTipoValidacao();
}
