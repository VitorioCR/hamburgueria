package hamburgueria;

/** [FACTORY METHOD] Interface produto — contrato que todos os itens do cardápio devem seguir. */
public interface IItemMenu {
    String getNome();
    double getPreco();
    String getDescricao();
    String executar();
}
