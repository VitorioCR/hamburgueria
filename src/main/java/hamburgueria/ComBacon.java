package hamburgueria;

/** [DECORATOR] Decorador concreto — adiciona bacon crocante ao lanche (+R$5). */
public class ComBacon extends LancheDecorator {

    public ComBacon(Lanche lanche) { super(lanche); }

    @Override
    public String getDescricao() { return lanche.getDescricao() + " + bacon crocante"; }

    @Override
    public double getPreco() { return lanche.getPreco() + 5.00; }
}
