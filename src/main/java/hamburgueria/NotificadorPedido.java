package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [OBSERVER] Subject (Observable) — notifica observadores quando o status do pedido muda. */
public class NotificadorPedido {

    private List<ObservadorPedido> observadores = new ArrayList<>();
    private int numeroPedido;
    private String statusAtual;

    public NotificadorPedido(int numeroPedido) { this.numeroPedido = numeroPedido; }

    public void registrarObservador(ObservadorPedido observador) { observadores.add(observador); }

    public void removerObservador(ObservadorPedido observador) { observadores.remove(observador); }

    public void atualizarStatus(String novoStatus) {
        this.statusAtual = novoStatus;
        notificarTodos();
    }

    private void notificarTodos() {
        for (ObservadorPedido obs : observadores) obs.atualizar(numeroPedido, statusAtual);
    }

    public String getStatusAtual() { return statusAtual; }
}
