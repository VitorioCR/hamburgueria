package hamburgueria;

/** [VISITOR] Interface visitante — define operações que podem ser aplicadas em qualquer ItemVisitavel. */
public interface RelatorioVisitor {
    String visitarHamburguer(ItemHamburguerMenu hamburguer);
    String visitarBebida(ItemBebidaMenu bebida);
    String visitarSobremesa(ItemSobremesaMenu sobremesa);
}
