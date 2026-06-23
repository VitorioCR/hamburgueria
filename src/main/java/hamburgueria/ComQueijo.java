package hamburgueria;

/** [DECORATOR] Decorador concreto — adiciona queijo cheddar ao lanche (+R$3). */
public class ComQueijo extends LancheDecorator {

    public ComQueijo(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + queijo cheddar"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 3.00; }
}
