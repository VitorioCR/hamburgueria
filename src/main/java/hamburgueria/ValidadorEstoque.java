package hamburgueria;

/** [CHAIN OF RESPONSIBILITY] Handler concreto — valida disponibilidade em estoque. */
public class ValidadorEstoque extends ValidadorPedido {

    @Override
    protected TipoValidacao getTipoValidacao() { return TipoValidacao.ESTOQUE; }

    @Override
    public String validar(SolicitacaoPedido solicitacao) {
        if (podeValidar(solicitacao)) {
            solicitacao.setAprovado(true);
            return "Estoque: ingredientes disponíveis para pedido #" + solicitacao.getNumeroPedido();
        }
        if (proximo != null) return proximo.validar(solicitacao);
        return "Nenhum validador disponível para: " + solicitacao.getTipoValidacao();
    }
}
