package hamburgueria;

import java.util.List;

/** [PROXY] Subject — interface que PedidoReal e PedidoProxy devem implementar. */
public interface IPedido {
    List<String> obterResumo();
    List<String> obterDetalhesPagamento(Gerente gerente);
}
