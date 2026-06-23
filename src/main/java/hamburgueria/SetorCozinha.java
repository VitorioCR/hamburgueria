package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [MEDIATOR] Participante concreto — setor de cozinha que recebe pedidos via CentralPedidos. */
public class SetorCozinha implements Participante {

    private String nome;
    private List<String> mensagensRecebidas = new ArrayList<>();

    public SetorCozinha(String nome) { this.nome = nome; }

    @Override
    public String getNome() { return nome; }

    @Override
    public void receberMensagem(String remetente, String mensagem) {
        mensagensRecebidas.add("[" + remetente + " → " + nome + "]: " + mensagem);
    }

    public List<String> getMensagensRecebidas() { return mensagensRecebidas; }
}
