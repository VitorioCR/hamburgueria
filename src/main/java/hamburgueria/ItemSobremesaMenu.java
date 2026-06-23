package hamburgueria;

/** [VISITOR] Elemento concreto — item de sobremesa do menu que aceita visitantes de auditoria. */
public class ItemSobremesaMenu implements ItemVisitavel {

    private String nome;
    private double preco;
    private boolean semGluten;

    public ItemSobremesaMenu(String nome, double preco, boolean semGluten) {
        this.nome = nome;
        this.preco = preco;
        this.semGluten = semGluten;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isSemGluten() { return semGluten; }

    @Override
    public String aceitar(RelatorioVisitor visitor) { return visitor.visitarSobremesa(this); }
}
