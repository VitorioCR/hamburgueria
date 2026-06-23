package hamburgueria;

/**
 * [ADAPTER] Adaptador — traduz a interface legada de GatewayPagamentoExterno
 * para a interface IFormaPagamento que o sistema conhece.
 */
public class PagamentoAdapter implements IFormaPagamento {

    private GatewayPagamentoExterno gateway;

    public PagamentoAdapter() {
        this.gateway = new GatewayPagamentoExterno();
    }

    @Override
    public boolean processarPagamento(double valor) {
        int resultado = gateway.efetuarCobranca("BRL", valor);
        return resultado == 0;
    }

    @Override
    public String getStatus() {
        return gateway.consultarStatusCobranca();
    }
}
