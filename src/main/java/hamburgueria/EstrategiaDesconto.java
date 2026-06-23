package hamburgueria;

/** [STRATEGY] Interface estratégia — contrato de cálculo de desconto trocável em runtime. */
public interface EstrategiaDesconto {
    double calcularDesconto(double valorOriginal);
    String getDescricao();
}
