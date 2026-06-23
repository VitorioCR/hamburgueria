package hamburgueria;

/** [FACTORY METHOD] Produto concreto — sobremesa do cardápio criada pela fábrica. */
public class ItemSobremesa implements IItemMenu {

    @Override
    public String getNome() { return "Sobremesa"; }

    @Override
    public double getPreco() { return 12.00; }

    @Override
    public String getDescricao() { return "Sorvete artesanal 2 bolas ou milkshake 300ml"; }

    @Override
    public String executar() {
        return "Preparando sobremesa deliciosa...";
    }
}
