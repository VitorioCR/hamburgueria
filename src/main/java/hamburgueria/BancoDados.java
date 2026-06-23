package hamburgueria;

import java.util.HashMap;
import java.util.Map;

/** [PROXY] Repositório simulado — armazena PedidoReal que o PedidoProxy consulta. */
public class BancoDados {

    private static Map<Integer, PedidoReal> pedidos = new HashMap<>();

    public static PedidoReal getPedido(Integer numero) { return pedidos.get(numero); }

    public static void addPedido(PedidoReal pedido) { pedidos.put(pedido.getNumero(), pedido); }
}
