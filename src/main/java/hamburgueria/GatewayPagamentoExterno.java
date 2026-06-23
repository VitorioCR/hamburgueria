package hamburgueria;

/**
 * [ADAPTER] Adaptado (Adaptee) — gateway de pagamento externo com interface incompatível (legada).
 * Retorna int em vez de boolean e usa parâmetro de moeda.
 */
public class GatewayPagamentoExterno {

    public int efetuarCobranca(String moeda, double quantia) {
        // Retorna 0 = sucesso, 1 = falha (interface legada)
        if (quantia > 0) {
            System.out.println("[GatewayExterno] Cobrança de " + moeda + " " + quantia + " efetuada com sucesso.");
            return 0;
        }
        return 1;
    }

    public String consultarStatusCobranca() {
        return "APROVADO";
    }
}
