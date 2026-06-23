package hamburgueria;

/** [MEDIATOR] Interface participante — todo ator que se comunica via CentralPedidos. */
public interface Participante {
    String getNome();
    void receberMensagem(String remetente, String mensagem);
}
