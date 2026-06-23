package hamburgueria;

/**
 * [STRATEGY] Contexto do padrão Strategy — o Caixa pode trocar sua estratégia de desconto
 * em tempo de execução via setEstrategiaDesconto().
 */
public class Caixa {

    private EstrategiaDesconto estrategiaDesconto;
    private double valorTotal;

    public Caixa(double valorTotal) { this.valorTotal = valorTotal; }

    public void setEstrategiaDesconto(EstrategiaDesconto estrategiaDesconto) {
        this.estrategiaDesconto = estrategiaDesconto;
    }

    public double calcularValorFinal() {
        if (estrategiaDesconto == null) return valorTotal;
        double desconto = estrategiaDesconto.calcularDesconto(valorTotal);
        return valorTotal - desconto;
    }

    public String getResumo() {
        if (estrategiaDesconto == null) return "Total: R$" + valorTotal + " (sem desconto)";
        double desconto = estrategiaDesconto.calcularDesconto(valorTotal);
        return estrategiaDesconto.getDescricao() + " | Total: R$" + calcularValorFinal() + " (economia: R$" + desconto + ")";
    }
}
