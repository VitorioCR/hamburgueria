package hamburgueria;

/** [VISITOR] Interface visitável — permite que RelatorioVisitor "visite" itens sem alterar suas classes. */
public interface ItemVisitavel {
    String aceitar(RelatorioVisitor visitor);
}
