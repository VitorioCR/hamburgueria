package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PadroesCriacaoTest {

    @Test
    public void testFactoryMethodCriaItensCorretos() {
        // Testando o Factory Method (ItemMenuFactory)
        IItemMenu item1 = ItemMenuFactory.obterItem("Hamburguer");
        assertTrue(item1 instanceof ItemHamburguer, "Deveria criar um Hamburguer");
        
        IItemMenu item2 = ItemMenuFactory.obterItem("Bebida");
        assertTrue(item2 instanceof ItemBebida, "Deveria criar uma Bebida");
        
        IItemMenu item3 = ItemMenuFactory.obterItem("Sobremesa");
        assertTrue(item3 instanceof ItemSobremesa, "Deveria criar uma Sobremesa");
    }

    @Test
    public void testAbstractFactoryCriaCombosDiferentes() {
        // Testando o Abstract Factory (FabricaComboClassico vs FabricaComboVegano)
        FabricaAbstrata fabricaClassica = new FabricaComboClassico();
        Embalagem embalagemClassica = fabricaClassica.createEmbalagem();
        Acompanhamento acompanhamentoClassico = fabricaClassica.createAcompanhamento();
        
        assertNotNull(embalagemClassica);
        assertNotNull(acompanhamentoClassico);
        assertTrue(acompanhamentoClassico.getNome().toLowerCase().contains("batata") || 
                   acompanhamentoClassico.getNome().toLowerCase().contains("classico"));

        FabricaAbstrata fabricaVegana = new FabricaComboVegano();
        Embalagem embalagemVegana = fabricaVegana.createEmbalagem();
        Acompanhamento acompanhamentoVegano = fabricaVegana.createAcompanhamento();
        
        assertNotNull(embalagemVegana);
        assertNotNull(acompanhamentoVegano);
        assertTrue(acompanhamentoVegano.getNome().toLowerCase().contains("salada") || 
                   acompanhamentoVegano.getNome().toLowerCase().contains("vegano"));
    }

    @Test
    public void testPrototypeCloneGaranteIndependencia() {
        // Testando Prototype (Clone de Hamburguer)
        Hamburguer original = new Hamburguer();
        original.setNome("Cheese Burger Original");
        Hamburguer clone = original.clone();
        
        assertNotSame(original, clone, "A instância clonada deve ser diferente da original (novo espaço de memória)");
        assertEquals(original.getNome(), clone.getNome(), "O conteúdo do clone deve ser igual ao original");
        
        clone.setNome("Cheese Burger Modificado");
        assertNotEquals(original.getNome(), clone.getNome(), "Modificar o clone não deve afetar o original");
    }

    @Test
    public void testBuilderConstrutorDePedido() {
        // Testando o Builder com cenários adicionais
        Pedido pedido = new PedidoBuilder()
            .setNumero(999)
            .setNomeCliente("Cliente VIP")
            .addItem("X-Bacon")
            .addItem("Refrigerante")
            .setFormaPagamento("PIX")
            .setParaViagem(true)
            .build();
            
        assertEquals(999, pedido.getNumero());
        assertEquals("Cliente VIP", pedido.getNomeCliente());
        assertEquals(2, pedido.getItens().size());
        assertEquals("PIX", pedido.getFormaPagamento());
        assertTrue(pedido.isParaViagem());
    }

    @Test
    public void testSingletonConfiguracaoUnica() {
        // Testando Singleton em múltiplos acessos
        ConfiguracaoRestaurante configA = ConfiguracaoRestaurante.getInstance();
        ConfiguracaoRestaurante configB = ConfiguracaoRestaurante.getInstance();
        
        assertSame(configA, configB, "Devem apontar para a mesma instância na memória");
        
        configA.setNomeRestaurante("Hamburgueria do Bairro");
        assertEquals("Hamburgueria do Bairro", configB.getNomeRestaurante(), "O estado deve ser compartilhado entre todas as chamadas");
    }
}
