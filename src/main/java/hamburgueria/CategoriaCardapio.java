package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [ITERATOR] Coleção iterável — categoria do cardápio que fornece seu próprio iterador. */
public class CategoriaCardapio {

    private String nome;
    private List<String> itens = new ArrayList<>();

    public CategoriaCardapio(String nome) { this.nome = nome; }

    public void adicionarItem(String item) { itens.add(item); }

    public String getNome() { return nome; }

    public IteradorCardapio criarIterador() { return new IteradorCategoriaImpl(itens); }

    private static class IteradorCategoriaImpl implements IteradorCardapio {
        private List<String> itens;
        private int posicao = 0;

        public IteradorCategoriaImpl(List<String> itens) { this.itens = itens; }

        @Override
        public boolean temProximo() { return posicao < itens.size(); }

        @Override
        public String proximo() { return itens.get(posicao++); }
    }
}
