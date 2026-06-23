package hamburgueria;

/** [STRATEGY] Estratégia concreta — desconto por cupom com percentual fixo. */
public class DescontoCupom implements EstrategiaDesconto {

    private double percentual;
    private String codigoCupom;

    public DescontoCupom(String codigoCupom, double percentual) {
        this.codigoCupom = codigoCupom;
        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(double valorOriginal) { return valorOriginal * percentual; }

    @Override
    public String getDescricao() {
        return "Cupom " + codigoCupom + " (" + (int)(percentual * 100) + "% off)";
    }
}
