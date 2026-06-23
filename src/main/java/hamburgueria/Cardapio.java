package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [FLYWEIGHT] Cliente que usa IngredienteFactory para popular o cardápio com cache de ingredientes. */
public class Cardapio {

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(String nomeItem, String nomeIngrediente, String categoria) {
        IngredienteFactory.getIngrediente(nomeIngrediente, categoria);
        ItemPedido item = new ItemPedido(nomeItem, nomeIngrediente, categoria);
        itens.add(item);
    }

    public List<String> listarItens() {
        List<String> saida = new ArrayList<>();
        for (ItemPedido item : itens) saida.add(item.obterItem());
        return saida;
    }
}
