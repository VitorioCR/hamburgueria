package hamburgueria;

/** [STRATEGY] Estratégia concreta — desconto por pontos de fidelidade (1 ponto = R$0,10, máx 20%). */
public class DescontoFidelidade implements EstrategiaDesconto {

    private int pontosFidelidade;

    public DescontoFidelidade(int pontosFidelidade) { this.pontosFidelidade = pontosFidelidade; }

    @Override
    public double calcularDesconto(double valorOriginal) {
        double desconto = pontosFidelidade * 0.10;
        double maxDesconto = valorOriginal * 0.20;
        return Math.min(desconto, maxDesconto);
    }

    @Override
    public String getDescricao() {
        return "Desconto fidelidade (" + pontosFidelidade + " pontos)";
    }
}
