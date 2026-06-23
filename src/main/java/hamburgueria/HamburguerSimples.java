package hamburgueria;

/** [DECORATOR] Componente concreto — lanche base sem decorações, preço R$18. */
public class HamburguerSimples implements Lanche {

    @Override
    public String getDescricao() { return "Hambúrguer simples (pão + carne + alface + tomate)"; }

    @Override
    public double getPreco() { return 18.00; }
}
