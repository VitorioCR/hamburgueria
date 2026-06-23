package hamburgueria;

import java.util.Arrays;
import java.util.List;

/** [PROXY] Real Subject — objeto real com todos os dados do pedido, acessado via PedidoProxy. */
public class PedidoReal implements IPedido {

    private Integer numero;
    private String nomeCliente;
    private String itens;
    private String formaPagamento;
    private double valorTotal;

    public PedidoReal(Integer numero, String nomeCliente, String itens, String formaPagamento, double valorTotal) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = itens;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
    }

    public PedidoReal(Integer numero) {
        this.numero = numero;
        PedidoReal obj = BancoDados.getPedido(numero);
        this.nomeCliente = obj.nomeCliente;
        this.itens = obj.itens;
        this.formaPagamento = obj.formaPagamento;
        this.valorTotal = obj.valorTotal;
    }

    public Integer getNumero() { return numero; }

    @Override
    public List<String> obterResumo() {
        return Arrays.asList("Pedido #" + numero, "Cliente: " + nomeCliente, "Itens: " + itens);
    }

    @Override
    public List<String> obterDetalhesPagamento(Gerente gerente) {
        return Arrays.asList("Forma: " + formaPagamento, "Total: R$" + valorTotal);
    }
}
