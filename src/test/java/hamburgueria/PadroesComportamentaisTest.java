package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PadroesComportamentaisTest {

    @Test
    public void testStrategyAplicaDescontosDiferentes() {
        // Testando Strategy: Desconto Dinâmico no Caixa
        Caixa caixa = new Caixa(100.0);
        
        caixa.setEstrategiaDesconto(new DescontoFidelidade(50)); // Ex: 50 pontos
        assertTrue(caixa.calcularValorFinal() < 100.0, "Desconto Fidelidade deve abater o valor original");
        
        caixa.setEstrategiaDesconto(new DescontoCupom("PROMO20", 0.20)); // Desconto percentual de 20%
        assertEquals(80.0, caixa.calcularValorFinal(), "Desconto Cupom deve descontar 20% do valor");
    }

    @Test
    public void testObserverNotificaClientes() {
        // Testando Observer: Sistema de Notificação
        NotificadorPedido notificador = new NotificadorPedido(101);
        ClienteObservador cliente1 = new ClienteObservador("Vitor");
        ClienteObservador cliente2 = new ClienteObservador("Maria");
        
        notificador.registrarObservador(cliente1);
        notificador.registrarObservador(cliente2);
        
        notificador.atualizarStatus("Pronto para Retirada");
        
        assertTrue(cliente1.getNotificacoes().stream().anyMatch(msg -> msg.contains("Pronto para Retirada")));
        assertTrue(cliente2.getNotificacoes().stream().anyMatch(msg -> msg.contains("Pronto para Retirada")));
        
        notificador.removerObservador(cliente2);
        notificador.atualizarStatus("Saiu para Entrega");
        
        assertTrue(cliente1.getNotificacoes().stream().anyMatch(msg -> msg.contains("Saiu para Entrega")));
        assertFalse(cliente2.getNotificacoes().stream().anyMatch(msg -> msg.contains("Saiu para Entrega")), "Maria foi removida, não deve receber esta notificação");
    }

    @Test
    public void testMementoSalvaERestauraEstado() {
        // Testando Memento: Undo no Carrinho
        Carrinho carrinho = new Carrinho();
        HistoricoCarrinho historico = new HistoricoCarrinho();
        
        carrinho.adicionarItem("Hamburguer", 20.0);
        historico.salvar(carrinho.salvarEstado());
        
        carrinho.adicionarItem("Refrigerante", 5.0);
        assertEquals(2, carrinho.getItens().size(), "Carrinho atual deve ter 2 itens");
        
        carrinho.restaurarEstado(historico.desfazer());
        assertEquals(1, carrinho.getItens().size(), "Carrinho deve voltar a ter 1 item após o Undo");
        assertTrue(carrinho.getItens().contains("Hamburguer"));
    }

    @Test
    public void testCommandExecutaAcoesCozinha() {
        // Testando Command: Fila de comandos da Cozinha
        GerenciadorPedidos invoker = new GerenciadorPedidos();
        ComandoCozinha preparar = new PrepararPedido(1, "X-Bacon");
        
        invoker.executarComando(preparar);
        assertEquals(1, invoker.getTotalComandos(), "O comando de preparo deve ser registrado no histórico");
        
        invoker.desfazerUltimoComando();
        assertEquals(0, invoker.getTotalComandos(), "O comando deve ser removido após o desfazer");
    }

    @Test
    public void testMediatorComunicaParticipantes() {
        // Testando Mediator: Chat entre Participantes
        CentralPedidos mediator = new CentralPedidos();
        SetorCozinha cozinha = new SetorCozinha("Cozinha");
        ClienteMediator cliente = new ClienteMediator("Vitor");
        
        mediator.registrar(cozinha);
        mediator.registrar(cliente);
        
        mediator.enviarMensagem(cozinha.getNome(), "O pedido está pronto!");
        
        boolean recebeuMensagem = false;
        for (String msg : cliente.getMensagensRecebidas()) {
            if (msg.contains("O pedido está pronto!")) {
                recebeuMensagem = true;
                break;
            }
        }
        assertTrue(recebeuMensagem, "O cliente deve receber a mensagem do setor cozinha através do Mediator");
    }

    @Test
    public void testVisitorGeraRelatorios() {
        // Testando Visitor: Extraindo relatório sem mexer nos objetos
        ItemHamburguerMenu burger = new ItemHamburguerMenu("Simples", 20.0, 500);
        ItemBebidaMenu bebida = new ItemBebidaMenu("Cola", 5.0, 300);
        
        RelatorioCardapioVisitor visitor = new RelatorioCardapioVisitor();
        
        String relatorioBurger = burger.aceitar(visitor);
        String relatorioBebida = bebida.aceitar(visitor);
        
        assertTrue(relatorioBurger.contains("HAMBÚRGUER"));
        assertTrue(relatorioBurger.contains("Simples"));
        
        assertTrue(relatorioBebida.contains("BEBIDA"));
        assertTrue(relatorioBebida.contains("Cola"));
    }
}
