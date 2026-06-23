package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaCompletoTest {

    @Test
    public void testCriarPedidoComBuilder() {
        Pedido pedido = new PedidoBuilder()
            .setNumero(101)
            .setNomeCliente("Vitor Teste")
            .addItem("Hamburguer Simples")
            .setFormaPagamento("Cartão")
            .build();

        assertEquals(101, pedido.getNumero());
        assertEquals("Vitor Teste", pedido.getNomeCliente());
        assertFalse(pedido.isParaViagem());
    }

    @Test
    public void testEstadoDoPedido() {
        PedidoContext context = new PedidoContext(101);
        assertEquals("Recebido", context.getNomeEstado());

        context.prepararPedido();
        assertEquals("Preparando", context.getNomeEstado());

        context.finalizarPedido();
        assertEquals("Pronto", context.getNomeEstado());
    }

    @Test
    public void testSingletonConfiguracao() {
        ConfiguracaoRestaurante config1 = ConfiguracaoRestaurante.getInstance();
        ConfiguracaoRestaurante config2 = ConfiguracaoRestaurante.getInstance();

        config1.setNomeRestaurante("Hamburgueria Java");
        assertEquals("Hamburgueria Java", config2.getNomeRestaurante());
        assertSame(config1, config2);
    }
}
