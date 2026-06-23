package hamburgueria;

/** [OBSERVER] Interface observador — contrato de notificação de mudança de status. */
public interface ObservadorPedido {
    void atualizar(int numeroPedido, String status);
}
