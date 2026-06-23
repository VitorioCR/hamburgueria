package hamburgueria;

/** [INTERPRETER] Cliente do interpretador — executa a árvore de expressões de receita. */
public class InterpretadorReceita {

    public double calcularTotalGramas(ExpressaoReceita expressao, ContextoReceita contexto) {
        return expressao.interpretar(contexto);
    }
}
