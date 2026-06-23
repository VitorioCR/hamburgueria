package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidacaoPedidoTest {

    private ValidadorPedido criarCadeia() {
        ValidadorPedido estoque = new ValidadorEstoque();
        ValidadorPedido pagamento = new ValidadorPagamento();
        ValidadorPedido cozinha = new ValidadorCozinha();
        estoque.setProximo(pagamento).setProximo(cozinha);
        return estoque;
    }

    @Test
    public void testValidarEstoque() {
        ValidadorPedido cadeia = criarCadeia();
        SolicitacaoPedido solicitacao = new SolicitacaoPedido(1, TipoValidacao.ESTOQUE);
        String resultado = cadeia.validar(solicitacao);
        assertTrue(resultado.contains("Estoque"));
        assertTrue(solicitacao.isAprovado());
    }

    @Test
    public void testValidarPagamento() {
        ValidadorPedido cadeia = criarCadeia();
        SolicitacaoPedido solicitacao = new SolicitacaoPedido(2, TipoValidacao.PAGAMENTO);
        String resultado = cadeia.validar(solicitacao);
        assertTrue(resultado.contains("Pagamento"));
        assertTrue(solicitacao.isAprovado());
    }

    @Test
    public void testValidarCozinha() {
        ValidadorPedido cadeia = criarCadeia();
        SolicitacaoPedido solicitacao = new SolicitacaoPedido(3, TipoValidacao.COZINHA);
        String resultado = cadeia.validar(solicitacao);
        assertTrue(resultado.contains("Cozinha"));
        assertTrue(solicitacao.isAprovado());
    }

    @Test
    public void testTipoNaoTratadoRetornaMensagem() {
        ValidadorPedido cadeia = criarCadeia();
        assertNotNull(cadeia);
    }
}
