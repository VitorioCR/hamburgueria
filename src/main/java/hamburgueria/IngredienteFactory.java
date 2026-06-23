package hamburgueria;

import java.util.HashMap;
import java.util.Map;

/**
 * [FLYWEIGHT] Fábrica de flyweights — retorna instância em cache ou cria nova.
 * Economiza memória compartilhando IngredienteCache entre múltiplos ItemPedido.
 */
public class IngredienteFactory {

    private static Map<String, IngredienteCache> ingredientes = new HashMap<>();

    public static IngredienteCache getIngrediente(String nome, String categoria) {
        IngredienteCache ingrediente = ingredientes.get(nome);
        if (ingrediente == null) {
            ingrediente = new IngredienteCache(nome, categoria);
            ingredientes.put(nome, ingrediente);
        }
        return ingrediente;
    }

    public static int getTotalIngredientes() { return ingredientes.size(); }
}
