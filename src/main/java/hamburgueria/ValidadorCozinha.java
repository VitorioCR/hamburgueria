package hamburgueria;

/** [CHAIN OF RESPONSIBILITY] Handler concreto — valida capacidade da cozinha. */
public class ValidadorCozinha extends ValidadorPedido {

    @Override
    protected TipoValidacao getTipoValidacao() { return TipoValidacao.COZINHA; }

    @Override
    public String validar(SolicitacaoPedido solicitacao) {
        if (podeValidar(solicitacao)) {
            solicitacao.setAprovado(true);
            return "Cozinha: capacidade disponível para pedido #" + solicitacao.getNumeroPedido();
        }
        if (proximo != null) return proximo.validar(solicitacao);
        return "Nenhum validador disponível para: " + solicitacao.getTipoValidacao();
    }
}
