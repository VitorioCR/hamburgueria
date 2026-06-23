package hamburgueria;

/** [VISITOR] Elemento concreto — item de hambúrguer do menu que aceita visitantes de auditoria. */
public class ItemHamburguerMenu implements ItemVisitavel {

    private String nome;
    private double preco;
    private int caloriasPorPorcao;

    public ItemHamburguerMenu(String nome, double preco, int caloriasPorPorcao) {
        this.nome = nome;
        this.preco = preco;
        this.caloriasPorPorcao = caloriasPorPorcao;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getCaloriasPorPorcao() { return caloriasPorPorcao; }

    @Override
    public String aceitar(RelatorioVisitor visitor) { return visitor.visitarHamburguer(this); }
}
