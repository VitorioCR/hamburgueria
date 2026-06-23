package hamburgueria;

/**
 * [FLYWEIGHT] Contexto extrínseco — ItemPedido possui estado externo (nomeItem)
 * e referencia o IngredienteCache compartilhado da fábrica.
 */
public class ItemPedido {

    private String nomeItem;
    private IngredienteCache ingredientePrincipal;

    public ItemPedido(String nomeItem, String nomeIngrediente, String categoria) {
        this.nomeItem = nomeItem;
        this.ingredientePrincipal = IngredienteFactory.getIngrediente(nomeIngrediente, categoria);
    }

    public String obterItem() {
        return "Item{nome='" + nomeItem + '\'' +
                ", ingrediente='" + ingredientePrincipal.getNome() + '\'' +
                ", categoria='" + ingredientePrincipal.getCategoria() + '\'' + '}';
    }
}
