package hamburgueria;

/** [FACTORY METHOD] Produto concreto — hambúrguer do cardápio criado pela fábrica. */
public class ItemHamburguer implements IItemMenu {

    @Override
    public String getNome() { return "Hambúrguer"; }

    @Override
    public double getPreco() { return 25.90; }

    @Override
    public String getDescricao() { return "Pão, hambúrguer 180g, alface, tomate e molho especial"; }

    @Override
    public String executar() {
        return "Preparando hambúrguer artesanal...";
    }
}
