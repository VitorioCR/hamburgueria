package hamburgueria;

/** [MEMENTO] Memento — snapshot imutável do estado do Carrinho. */
public class CarrinhoMemento {

    private final String itens;
    private final double total;

    public CarrinhoMemento(String itens, double total) {
        this.itens = itens;
        this.total = total;
    }

    public String getItens() { return itens; }
    public double getTotal() { return total; }
}
