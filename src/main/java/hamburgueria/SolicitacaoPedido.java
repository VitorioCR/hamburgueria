package hamburgueria;

/** [CHAIN OF RESPONSIBILITY] Solicitação que percorre a cadeia de validadores. */
public class SolicitacaoPedido {

    private int numeroPedido;
    private TipoValidacao tipoValidacao;
    private boolean aprovado;

    public SolicitacaoPedido(int numeroPedido, TipoValidacao tipoValidacao) {
        this.numeroPedido = numeroPedido;
        this.tipoValidacao = tipoValidacao;
        this.aprovado = false;
    }

    public int getNumeroPedido() { return numeroPedido; }
    public TipoValidacao getTipoValidacao() { return tipoValidacao; }
    public boolean isAprovado() { return aprovado; }
    public void setAprovado(boolean aprovado) { this.aprovado = aprovado; }
}
