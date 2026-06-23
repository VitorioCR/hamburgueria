package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [MEDIATOR] Participante concreto — cliente que envia e recebe mensagens via CentralPedidos. */
public class ClienteMediator implements Participante {

    private String nome;
    private List<String> mensagensRecebidas = new ArrayList<>();

    public ClienteMediator(String nome) { this.nome = nome; }

    @Override
    public String getNome() { return nome; }

    @Override
    public void receberMensagem(String remetente, String mensagem) {
        mensagensRecebidas.add("[" + remetente + " → " + nome + "]: " + mensagem);
    }

    public List<String> getMensagensRecebidas() { return mensagensRecebidas; }
}
