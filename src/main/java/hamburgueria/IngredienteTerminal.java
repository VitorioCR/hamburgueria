package hamburgueria;

/** [INTERPRETER] Terminal — busca a quantidade de um ingrediente no contexto. */
public class IngredienteTerminal implements ExpressaoReceita {

    private String nomeIngrediente;

    public IngredienteTerminal(String nomeIngrediente) { this.nomeIngrediente = nomeIngrediente; }

    @Override
    public double interpretar(ContextoReceita contexto) {
        return contexto.getQuantidade(nomeIngrediente);
    }
}
