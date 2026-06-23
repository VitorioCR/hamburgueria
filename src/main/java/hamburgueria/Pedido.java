package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [BUILDER] Produto do padrão Builder — objeto complexo construído passo-a-passo por PedidoBuilder. */
public class Pedido {

    private int numero;
    private String nomeCliente;
    private String observacoes;
    private String enderecoEntrega;
    private String formaPagamento;
    private List<String> itens;
    private boolean paraViagem;

    public Pedido() {
        this.numero = 0;
        this.nomeCliente = "";
        this.observacoes = "";
        this.enderecoEntrega = "";
        this.formaPagamento = "";
        this.itens = new ArrayList<>();
        this.paraViagem = false;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public List<String> getItens() { return itens; }
    public void setItens(List<String> itens) { this.itens = itens; }

    public boolean isParaViagem() { return paraViagem; }
    public void setParaViagem(boolean paraViagem) { this.paraViagem = paraViagem; }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", cliente='" + nomeCliente + '\'' +
                ", itens=" + itens +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", paraViagem=" + paraViagem +
                '}';
    }
}
