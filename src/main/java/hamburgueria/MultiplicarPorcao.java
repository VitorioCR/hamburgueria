package hamburgueria;

/** [INTERPRETER] Expressão não-terminal — multiplica quantidade de um ingrediente por fator. */
public class MultiplicarPorcao implements ExpressaoReceita {

    private ExpressaoReceita expressao;
    private double fator;

    public MultiplicarPorcao(ExpressaoReceita expressao, double fator) {
        this.expressao = expressao;
        this.fator = fator;
    }

    @Override
    public double interpretar(ContextoReceita contexto) {
        return expressao.interpretar(contexto) * fator;
    }
}
