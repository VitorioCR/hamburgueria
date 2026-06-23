package hamburgueria;

/** [DECORATOR] Decorador concreto — adiciona molho especial extra ao lanche (+R$2). */
public class ComMolhoExtra extends LancheDecorator {

    public ComMolhoExtra(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + molho especial extra"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 2.00; }
}
