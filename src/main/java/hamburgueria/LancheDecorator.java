package hamburgueria;

/** [DECORATOR] Decorador base abstrato — envolve um Lanche e delega para ele. */
public abstract class LancheDecorator implements Lanche {

    protected Lanche lanche;

    public LancheDecorator(Lanche lanche) { this.lanche = lanche; }

    @Override
    public String getDescricao() { return lanche.getDescricao(); }

    @Override
    public double getPreco() { return lanche.getPreco(); }
}
