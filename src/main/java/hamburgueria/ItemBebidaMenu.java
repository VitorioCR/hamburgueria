package hamburgueria;

/** [VISITOR] Elemento concreto — item de bebida do menu que aceita visitantes de auditoria. */
public class ItemBebidaMenu implements ItemVisitavel {

    private String nome;
    private double preco;
    private int mlPorCopo;

    public ItemBebidaMenu(String nome, double preco, int mlPorCopo) {
        this.nome = nome;
        this.preco = preco;
        this.mlPorCopo = mlPorCopo;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getMlPorCopo() { return mlPorCopo; }

    @Override
    public String aceitar(RelatorioVisitor visitor) { return visitor.visitarBebida(this); }
}
