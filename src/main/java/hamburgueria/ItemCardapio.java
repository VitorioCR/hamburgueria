package hamburgueria;

import java.util.List;

/** [COMPOSITE] Componente — interface unificada para itens simples e compostos do cardápio. */
public interface ItemCardapio {
    String getNome();
    double getPreco();
    List<String> listarItens();
}
