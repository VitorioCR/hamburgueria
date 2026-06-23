package hamburgueria;

import java.util.HashMap;
import java.util.Map;

/** [INTERPRETER] Contexto — armazena as quantidades de ingredientes para a gramática de receitas. */
public class ContextoReceita {

    private Map<String, Double> quantidades = new HashMap<>();

    public void setQuantidade(String ingrediente, double quantidade) {
        quantidades.put(ingrediente, quantidade);
    }

    public double getQuantidade(String ingrediente) {
        return quantidades.getOrDefault(ingrediente, 0.0);
    }
}
