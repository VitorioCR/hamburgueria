package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [MEMENTO] Originador — carrinho de compras que pode salvar e restaurar seu estado. */
public class Carrinho {

    private List<String> itens = new ArrayList<>();
    private double total = 0.0;

    public void adicionarItem(String item, double preco) {
        itens.add(item);
        total += preco;
    }

    public void removerItem(String item, double preco) {
        itens.remove(item);
        total -= preco;
    }

    public CarrinhoMemento salvarEstado() {
        return new CarrinhoMemento(String.join(", ", itens), total);
    }

    public void restaurarEstado(CarrinhoMemento memento) {
        this.itens = new ArrayList<>(List.of(memento.getItens().split(", ")));
        this.total = memento.getTotal();
    }

    public List<String> getItens() { return itens; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Carrinho{itens=" + itens + ", total=R$" + total + "}";
    }
}
