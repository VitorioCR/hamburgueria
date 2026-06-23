package hamburgueria;

/** [VISITOR] Visitante concreto — audita o cardápio gerando relatório nutricional e de preços. */
public class RelatorioCardapioVisitor implements RelatorioVisitor {

    @Override
    public String visitarHamburguer(ItemHamburguerMenu hamburguer) {
        return "[HAMBÚRGUER] " + hamburguer.getNome() +
                " | Preço: R$" + hamburguer.getPreco() +
                " | Calorias: " + hamburguer.getCaloriasPorPorcao() + "kcal";
    }

    @Override
    public String visitarBebida(ItemBebidaMenu bebida) {
        return "[BEBIDA] " + bebida.getNome() +
                " | Preço: R$" + bebida.getPreco() +
                " | Volume: " + bebida.getMlPorCopo() + "ml";
    }

    @Override
    public String visitarSobremesa(ItemSobremesaMenu sobremesa) {
        return "[SOBREMESA] " + sobremesa.getNome() +
                " | Preço: R$" + sobremesa.getPreco() +
                (sobremesa.isSemGluten() ? " | SEM GLÚTEN" : "");
    }
}
