package hamburgueria;

/** [INTERPRETER] Expressão não-terminal — soma dois ingredientes. */
public class SomaIngredientes implements ExpressaoReceita {

    private ExpressaoReceita esquerda;
    private ExpressaoReceita direita;

    public SomaIngredientes(ExpressaoReceita esquerda, ExpressaoReceita direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar(ContextoReceita contexto) {
        return esquerda.interpretar(contexto) + direita.interpretar(contexto);
    }
}
