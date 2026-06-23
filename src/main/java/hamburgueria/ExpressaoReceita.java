package hamburgueria;

/** [INTERPRETER] Interface expressão — base para expressões terminais e compostas da gramática de receitas. */
public interface ExpressaoReceita {
    double interpretar(ContextoReceita contexto);
}
