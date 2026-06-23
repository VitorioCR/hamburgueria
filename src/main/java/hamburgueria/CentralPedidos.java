package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/**
 * [MEDIATOR] Mediador central — concentra toda comunicação entre Participantes,
 * evitando dependências diretas entre Cliente e SetorCozinha.
 */
public class CentralPedidos {

    private List<Participante> participantes = new ArrayList<>();
    private List<String> mensagens = new ArrayList<>();

    public void registrar(Participante participante) { participantes.add(participante); }

    public void enviarMensagem(String remetente, String mensagem) {
        String log = "[" + remetente + "]: " + mensagem;
        mensagens.add(log);
        for (Participante p : participantes) {
            if (!p.getNome().equals(remetente)) {
                p.receberMensagem(remetente, mensagem);
            }
        }
    }

    public List<String> getMensagens() { return mensagens; }
}
