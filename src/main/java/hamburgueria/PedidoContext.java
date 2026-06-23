package hamburgueria;

/** [STATE] Contexto — mantém referência ao EstadoPedido atual e delega ações para ele. */
public class PedidoContext {

    private EstadoPedido estadoAtual;
    private int numero;

    public PedidoContext(int numero) {
        this.numero = numero;
        this.estadoAtual = new EstadoRecebido();
    }

    public void setEstado(EstadoPedido estado) { this.estadoAtual = estado; }

    public String getNomeEstado() { return estadoAtual.getNomeEstado(); }

    public String receberPedido() { return estadoAtual.receberPedido(this); }
    public String prepararPedido() { return estadoAtual.prepararPedido(this); }
    public String finalizarPedido() { return estadoAtual.finalizarPedido(this); }
    public String cancelarPedido() { return estadoAtual.cancelarPedido(this); }

    public int getNumero() { return numero; }
}
