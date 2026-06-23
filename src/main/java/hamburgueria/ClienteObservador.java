package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [OBSERVER] Observador concreto — cliente que recebe push notifications de status do pedido. */
public class ClienteObservador implements ObservadorPedido {

    private String nome;
    private List<String> notificacoes = new ArrayList<>();

    public ClienteObservador(String nome) { this.nome = nome; }

    @Override
    public void atualizar(int numeroPedido, String status) {
        String msg = "Notificação para " + nome + ": Pedido #" + numeroPedido + " → " + status;
        notificacoes.add(msg);
    }

    public List<String> getNotificacoes() { return notificacoes; }
    public String getNome() { return nome; }
}
