package hamburgueria;

/** [FACTORY METHOD] Produto concreto — bebida do cardápio criada pela fábrica. */
public class ItemBebida implements IItemMenu {

    @Override
    public String getNome() { return "Bebida"; }

    @Override
    public double getPreco() { return 8.00; }

    @Override
    public String getDescricao() { return "Refrigerante 350ml ou suco natural"; }

    @Override
    public String executar() {
        return "Preparando bebida gelada...";
    }
}
