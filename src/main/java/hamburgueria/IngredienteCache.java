package hamburgueria;

/**
 * [FLYWEIGHT] Objeto compartilhado (intrínseco) — ingrediente de cache com estado imutável.
 * Renomeado de Ingrediente para IngredienteCache para evitar conflito com composite.Ingrediente.
 */
public class IngredienteCache {

    private String nome;
    private String categoria;

    public IngredienteCache(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
}
