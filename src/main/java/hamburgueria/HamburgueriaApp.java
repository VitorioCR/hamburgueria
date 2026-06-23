package hamburgueria;

import java.util.List;

/**
 * Aplicação principal da Hamburgueria Artesanal.
 * Demonstra a integração dos 23 Padrões de Projeto GoF em um único pacote coeso.
 *
 * Todos os padrões convivem no pacote "hamburgueria" sem subpacotes,
 * comunicando-se diretamente sem necessidade de imports entre pacotes.
 */
public class HamburgueriaApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("🍟 BEM-VINDO AO SIMULADOR DA HAMBURGUERIA ARTESANAL 🍔");
        System.out.println("         (Operando com 23 Padrões de Projeto GoF)         ");
        System.out.println("==========================================================\n");

        // ---------------------------------------------------------
        // 1. INICIALIZAÇÃO (SINGLETON, BRIDGE, FLYWEIGHT)
        // ---------------------------------------------------------
        System.out.println("--- 1. INICIALIZANDO O SISTEMA ---");
        ConfiguracaoRestaurante config = ConfiguracaoRestaurante.getInstance();
        config.setNomeRestaurante("Hamburgueria Java Patterns");
        System.out.println("[SINGLETON] Restaurante configurado: " + config.getNomeRestaurante());

        Funcionario caixaVirtual = new Atendente("Maria", 1500.0, new TurnoManha());
        System.out.println("[BRIDGE] Funcionário alocado: " + caixaVirtual.toString());

        IngredienteFactory.getIngrediente("Pão Brioche", "Pão");
        IngredienteFactory.getIngrediente("Hambúrguer 180g", "Carne");
        IngredienteFactory.getIngrediente("Queijo Cheddar", "Laticínio");
        System.out.println("[FLYWEIGHT] Memória economizada fazendo cache de 3 ingredientes básicos.\n");

        // ---------------------------------------------------------
        // 2. EXIBINDO O CARDÁPIO (COMPOSITE, FACTORY METHOD, ABSTRACT FACTORY, ITERATOR, VISITOR)
        // ---------------------------------------------------------
        System.out.println("--- 2. CARREGANDO E EXIBINDO O CARDÁPIO ---");
        Combo comboClassico = new Combo("Combo Master", new FabricaComboClassico());
        System.out.println("[ABSTRACT FACTORY] Criado Familia de Objetos: " + comboClassico.descrever());

        IItemMenu itemBebida = ItemMenuFactory.obterItem("Bebida");
        System.out.println("[FACTORY METHOD] Fabricado via reflection: " + itemBebida.executar());

        // Montando o composite para listar o cardapio
        ComboComposite menuMaster = new ComboComposite("Menu Master");
        HamburguerComposite hComposite = new HamburguerComposite("Mega Bacon");
        hComposite.adicionarIngrediente(new Ingrediente("Pão", 2.0));
        hComposite.adicionarIngrediente(new Ingrediente("Carne", 15.0));
        menuMaster.adicionarItem(hComposite);
        System.out.println("[COMPOSITE] Cardápio montado em estrutura de árvore. (Mega Bacon Total = R$" + hComposite.getPreco() + ")");

        // Iterando categorias
        CategoriaCardapio categoria = new CategoriaCardapio("Destaques");
        categoria.adicionarItem("Mega Bacon");
        categoria.adicionarItem("Combo Master");
        IteradorCardapio iterador = categoria.criarIterador();
        System.out.println("[ITERATOR] Varrendo a categoria '" + categoria.getNome() + "':");
        while (iterador.temProximo()) {
            System.out.println("  - " + iterador.proximo());
        }

        // Auditoria nutricional
        ItemHamburguerMenu relatorioHamburguer = new ItemHamburguerMenu("Mega Bacon", 35.0, 950);
        RelatorioCardapioVisitor visitor = new RelatorioCardapioVisitor();
        System.out.println("[VISITOR] Auditoria sem alterar a classe original: " + relatorioHamburguer.aceitar(visitor) + "\n");

        // ---------------------------------------------------------
        // 3. CARRINHO E CRIAÇÃO DO PEDIDO (MEMENTO, BUILDER, PROTOTYPE, DECORATOR)
        // ---------------------------------------------------------
        System.out.println("--- 3. CLIENTE FAZENDO O PEDIDO ---");
        Carrinho carrinho = new Carrinho();
        HistoricoCarrinho historico = new HistoricoCarrinho();

        carrinho.adicionarItem("Combo Master", 45.0);
        historico.salvar(carrinho.salvarEstado()); // Snapshot do estado do carrinho
        carrinho.adicionarItem("Milkshake", 15.0);
        System.out.println("[MEMENTO] Cliente removeu o Milkshake. Desfazendo carrinho (Ctrl+Z)...");
        carrinho.restaurarEstado(historico.desfazer());

        // Cliente monta um lanche hiper customizado no Builder
        Pedido pedidoFinal = new PedidoBuilder()
                .setNumero(1020)
                .setNomeCliente("Vitor")
                .addItem(carrinho.getItens().get(0))
                .setFormaPagamento("Cartão de Crédito")
                .setEnderecoEntrega("Mesa 05")
                .build();
        System.out.println("[BUILDER] Objeto complexo de Pedido construído passo-a-passo. Cliente: " + pedidoFinal.getNomeCliente());

        // O amigo do cliente quer exatamente o mesmo hambúrguer
        Hamburguer burgerAmigo1 = new Hamburguer();
        burgerAmigo1.setNome("Clássico");
        burgerAmigo1.setTemBacon(true);
        Hamburguer burgerAmigo2 = burgerAmigo1.clone();
        System.out.println("[PROTOTYPE] Hambúrguer clonado para o amigo: " + burgerAmigo2.getNome() + " (Com Bacon: " + burgerAmigo2.isTemBacon() + ")");

        // O cliente também pediu um Lanche Decorado dinamicamente
        Lanche lancheCustom = new ComQueijo(new ComBacon(new HamburguerSimples()));
        System.out.println("[DECORATOR] Lanche dinâmico gerado em tempo de execução: " + lancheCustom.getDescricao() + " (Preço: R$" + lancheCustom.getPreco() + ")\n");

        // ---------------------------------------------------------
        // 4. PROCESSAMENTO E VALIDAÇÕES (STRATEGY, ADAPTER, FACADE, CHAIN OF RESP.)
        // ---------------------------------------------------------
        System.out.println("--- 4. PROCESSANDO NO CAIXA ---");
        Caixa caixa = new Caixa(60.0); // Total arbitrário
        caixa.setEstrategiaDesconto(new DescontoFidelidade(50)); // 50 pontos
        System.out.println("[STRATEGY] Desconto dinâmico no caixa aplicado: " + caixa.getResumo());

        IFormaPagamento maquinaCartao = new PagamentoAdapter();
        boolean pago = maquinaCartao.processarPagamento(caixa.calcularValorFinal());
        System.out.println("[ADAPTER] Gateway legado processado via Adapter. Aprovado? " + pago);

        // Dispara a chain de validações interna da Facade
        PedidoFacade fachada = new PedidoFacade();
        List<String> logsProcessamento = fachada.realizarPedido(pedidoFinal.getNumero());
        System.out.println("[FACADE & CHAIN OF RESPONSIBILITY] Fachada delegou o fluxo que passou pela cadeia de validação:");
        for (String log : logsProcessamento) {
            System.out.println("  - " + log);
        }
        System.out.println();

        // ---------------------------------------------------------
        // 5. PREPARO NA COZINHA E COMUNICAÇÃO (STATE, TEMPLATE METHOD, COMMAND, INTERPRETER, OBSERVER, MEDIATOR)
        // ---------------------------------------------------------
        System.out.println("--- 5. AÇÃO NA COZINHA E COMUNICAÇÃO ---");
        PedidoContext maquinaEstado = new PedidoContext(pedidoFinal.getNumero());
        System.out.println("[STATE] Pedido na catraca de estados: Atual -> " + maquinaEstado.getNomeEstado());
        maquinaEstado.prepararPedido();
        System.out.println("[STATE] Mudança de estado permitida e fluida: Novo Atual -> " + maquinaEstado.getNomeEstado());

        PrepararHamburguer preparo = new PrepararHamburguer();
        System.out.println("[TEMPLATE METHOD] Algoritmo esqueleto executando passos fixos e variáveis:");
        List<String> passos = preparo.preparar();
        System.out.println("  -> " + passos.get(0) + " ... " + passos.get(passos.size() - 1));

        GerenciadorPedidos comandosCozinha = new GerenciadorPedidos();
        comandosCozinha.executarComando(new PrepararPedido(pedidoFinal.getNumero(), "Mega Bacon com queijo extra"));
        System.out.println("[COMMAND] Ordem de preparo encapsulada num comando e colocada na esteira da cozinha.");

        // O chef precisa calcular os gramas de carne para 3 Mega Bacons (usando Interpreter)
        ContextoReceita contexto = new ContextoReceita();
        contexto.setQuantidade("Carne", 150.0);
        ExpressaoReceita receitaMatematica = new MultiplicarPorcao(new IngredienteTerminal("Carne"), 3);
        InterpretadorReceita interpretador = new InterpretadorReceita();
        System.out.println("[INTERPRETER] Gramatura calculada via árvore de expressões: " + interpretador.calcularTotalGramas(receitaMatematica, contexto) + " gramas.");

        NotificadorPedido ifoodNotificador = new NotificadorPedido(pedidoFinal.getNumero());
        ClienteObservador clienteApp = new ClienteObservador(pedidoFinal.getNomeCliente());
        ifoodNotificador.registrarObservador(clienteApp);
        ifoodNotificador.atualizarStatus("Seu pedido já está no grau! Quase pronto.");
        System.out.println("[OBSERVER] Push notification recebido pelo cliente: " + clienteApp.getNotificacoes().get(0));

        CentralPedidos chatMediator = new CentralPedidos();
        ClienteMediator c1 = new ClienteMediator("Vitor");
        SetorCozinha coz = new SetorCozinha("Cozinheiro Chefe");
        chatMediator.registrar(c1);
        chatMediator.registrar(coz);
        chatMediator.enviarMensagem("Vitor", "Por favor, não mandem maionese!");
        System.out.println("[MEDIATOR] Centralizou o chat. Cozinha recebeu: " + coz.getMensagensRecebidas().get(0) + "\n");

        // ---------------------------------------------------------
        // 6. FINALIZAÇÃO E SEGURANÇA (PROXY)
        // ---------------------------------------------------------
        System.out.println("--- 6. ENTREGA E RELATÓRIO DO GERENTE ---");
        maquinaEstado.finalizarPedido(); // Vai para Pronto
        maquinaEstado.finalizarPedido(); // Vai para Entregue
        comandosCozinha.executarComando(new EntregarPedido(pedidoFinal.getNumero()));
        System.out.println("[STATE] Pedido Finalizado com Estado Atual: " + maquinaEstado.getNomeEstado());

        // Cadastra o PedidoReal no Banco de Dados Fake para o Proxy atuar
        BancoDados.addPedido(new PedidoReal(pedidoFinal.getNumero(), pedidoFinal.getNomeCliente(), "Combo Mega", "Cartão (ID Transação: 9876)", 85.0));

        IPedido controleAcesso = new PedidoProxy(pedidoFinal.getNumero());
        System.out.println("[PROXY] Acessando resumo do banco aberto ao publico: " + controleAcesso.obterResumo().get(0));

        Gerente gerente = new Gerente("Admin (Dono)", true);
        System.out.println("[PROXY] Verificando detalhes confidenciais de pagamento (Apenas admin): " + controleAcesso.obterDetalhesPagamento(gerente));

        System.out.println("\n==========================================================");
        System.out.println("✅ SUCESSO! O SISTEMA EXECUTOU OS 23 PADRÕES DE PROJETO! ");
        System.out.println("==========================================================");
    }
}
