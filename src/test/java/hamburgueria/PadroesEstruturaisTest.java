package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PadroesEstruturaisTest {

    @Test
    public void testDecoratorAdicionaIngredientes() {
        // Testando Decorator: Hamburguer base + Bacon + Queijo
        Lanche meuBurger = new HamburguerSimples();
        assertEquals(18.0, meuBurger.getPreco()); // Preço base do HamburguerSimples
        
        meuBurger = new ComBacon(meuBurger);
        assertEquals(23.0, meuBurger.getPreco()); // + 5.0 do bacon
        assertTrue(meuBurger.getDescricao().toLowerCase().contains("bacon"));
        
        meuBurger = new ComQueijo(meuBurger);
        assertEquals(26.0, meuBurger.getPreco()); // + 3.0 do queijo
        assertTrue(meuBurger.getDescricao().toLowerCase().contains("queijo"));
    }

    @Test
    public void testCompositeAgrupaItens() {
        // Testando Composite: ComboComposite com Itens
        ComboComposite combo = new ComboComposite("Combo Casal");
        
        ItemCardapio burger1 = new Ingrediente("Burger 1", 20.0);
        ItemCardapio bebida1 = new Ingrediente("Refrigerante", 5.0);
        
        combo.adicionarItem(burger1);
        combo.adicionarItem(bebida1);
        
        // O preço do combo deve ser a soma dos itens
        double precoEsperado = burger1.getPreco() + bebida1.getPreco();
        assertEquals(precoEsperado, combo.getPreco());
        assertTrue(combo.getNome().contains("Combo Casal"));
    }

    @Test
    public void testFacadeIntegraSetores() {
        // Testando Facade: Centralizando as chamadas do Pedido
        PedidoFacade facade = new PedidoFacade();
        
        // Deve processar chamando os setores caixa, cozinha e entrega
        assertDoesNotThrow(() -> {
            facade.realizarPedido(101);
        }, "A execução do PedidoFacade não deve lançar exceções");
    }

    @Test
    public void testAdapterConvertePagamento() {
        // Testando Adapter: Integrando Gateway de Pagamento
        PagamentoAdapter adapter = new PagamentoAdapter();
        
        boolean resultado = adapter.processarPagamento(50.0);
        assertTrue(resultado, "O Adapter deve conseguir repassar e aprovar o pagamento no Gateway externo");
    }

    @Test
    public void testProxyControlaAcesso() {
        // Populando banco de dados falso para o Proxy achar
        BancoDados.addPedido(new PedidoReal(101, "João", "Burger", "PIX", 25.0));
        
        // Testando Proxy: Lazy Loading / Controle de Acesso
        IPedido proxy = new PedidoProxy(101);
        Gerente gerenteSemAcesso = new Gerente("João", false);
        
        assertThrows(IllegalArgumentException.class, () -> {
            proxy.obterDetalhesPagamento(gerenteSemAcesso);
        }, "O Proxy deve bloquear a exibição se não houver permissão");
        
        Gerente gerenteComAcesso = new Gerente("Vitor", true);
        assertDoesNotThrow(() -> {
            proxy.obterDetalhesPagamento(gerenteComAcesso);
        }, "O Proxy deve permitir a exibição se houver permissão");
    }

    @Test
    public void testFlyweightCacheIngredientes() {
        // Testando Flyweight / Bridge: Cache de Ingredientes para economizar memória
        IngredienteCache ing1 = IngredienteFactory.getIngrediente("Carne", "Proteina");
        IngredienteCache ing2 = IngredienteFactory.getIngrediente("Carne", "Proteina");
        IngredienteCache ing3 = IngredienteFactory.getIngrediente("Pao", "Carboidrato");
        
        assertSame(ing1, ing2, "Devem compartilhar a mesma instância de Carne no Cache (Flyweight)");
        assertNotSame(ing1, ing3, "Carne e Pao são instâncias diferentes");
    }
}
