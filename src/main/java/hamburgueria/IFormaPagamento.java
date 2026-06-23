package hamburgueria;

/** [ADAPTER] Interface alvo do sistema — contrato de pagamento que o sistema espera. */
public interface IFormaPagamento {
    boolean processarPagamento(double valor);
    String getStatus();
}
