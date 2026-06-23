package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [COMPOSITE] Composite — hambúrguer composto por vários ingredientes (folhas). */
public class HamburguerComposite implements ItemCardapio {

    private String nome;
    private List<ItemCardapio> ingredientes = new ArrayList<>();

    public HamburguerComposite(String nome) { this.nome = nome; }

    public void adicionarIngrediente(ItemCardapio item) { ingredientes.add(item); }
    public void removerIngrediente(ItemCardapio item) { ingredientes.remove(item); }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() {
        return ingredientes.stream().mapToDouble(ItemCardapio::getPreco).sum();
    }

    @Override
    public List<String> listarItens() {
        List<String> lista = new ArrayList<>();
        lista.add("=== " + nome + " ===");
        for (ItemCardapio item : ingredientes) lista.addAll(item.listarItens());
        return lista;
    }
}
