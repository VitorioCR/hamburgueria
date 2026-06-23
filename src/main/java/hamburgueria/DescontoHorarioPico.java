package hamburgueria;

/** [STRATEGY] Estratégia concreta — desconto de 5% no horário de pico (almoço/jantar). */
public class DescontoHorarioPico implements EstrategiaDesconto {

    @Override
    public double calcularDesconto(double valorOriginal) { return valorOriginal * 0.05; }

    @Override
    public String getDescricao() { return "Desconto horário de pico (5%)"; }
}
