package hamburgueria;

import java.util.Stack;

/** [MEMENTO] Caretaker — guarda e restaura snapshots do Carrinho (Ctrl+Z). */
public class HistoricoCarrinho {

    private Stack<CarrinhoMemento> historico = new Stack<>();

    public void salvar(CarrinhoMemento memento) { historico.push(memento); }

    public CarrinhoMemento desfazer() {
        if (!historico.isEmpty()) return historico.pop();
        return null;
    }

    public int getTamanhoHistorico() { return historico.size(); }
}
