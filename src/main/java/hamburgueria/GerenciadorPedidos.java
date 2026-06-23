package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [COMMAND] Invocador — armazena e executa comandos da cozinha, permite desfazer. */
public class GerenciadorPedidos {

    private List<ComandoCozinha> historico = new ArrayList<>();

    public void executarComando(ComandoCozinha comando) {
        comando.executar();
        historico.add(comando);
    }

    public void desfazerUltimoComando() {
        if (!historico.isEmpty()) {
            ComandoCozinha ultimo = historico.remove(historico.size() - 1);
            ultimo.desfazer();
        }
    }

    public int getTotalComandos() { return historico.size(); }
}
