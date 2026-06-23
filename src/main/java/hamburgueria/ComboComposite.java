package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [COMPOSITE] Composite raiz — agrupa hambúrgueres e outros itens em combos. */
public class ComboComposite implements ItemCardapio {

    private String nome;
    private List<ItemCardapio> itens = new ArrayList<>();

    public ComboComposite(String nome) { this.nome = nome; }

    public void adicionarItem(ItemCardapio item) { itens.add(item); }
    public void removerItem(ItemCardapio item) { itens.remove(item); }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() {
        return itens.stream().mapToDouble(ItemCardapio::getPreco).sum();
    }

    @Override
    public List<String> listarItens() {
        List<String> lista = new ArrayList<>();
        lista.add("====== COMBO: " + nome + " ======");
        for (ItemCardapio item : itens) lista.addAll(item.listarItens());
        return lista;
    }
}
