package hamburgueria;

/** [ITERATOR] Interface do iterador — percorre itens do cardápio sem expor estrutura interna. */
public interface IteradorCardapio {
    boolean temProximo();
    String proximo();
}
