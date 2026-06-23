package hamburgueria;

/** [CHAIN OF RESPONSIBILITY] Handler concreto — valida aprovação de pagamento. */
public class ValidadorPagamento extends ValidadorPedido {

    @Override
    protected TipoValidacao getTipoValidacao() { return TipoValidacao.PAGAMENTO; }

    @Override
    public String validar(SolicitacaoPedido solicitacao) {
        if (podeValidar(solicitacao)) {
            solicitacao.setAprovado(true);
            return "Pagamento: aprovado para pedido #" + solicitacao.getNumeroPedido();
        }
        if (proximo != null) return proximo.validar(solicitacao);
        return "Nenhum validador disponível para: " + solicitacao.getTipoValidacao();
    }
}
