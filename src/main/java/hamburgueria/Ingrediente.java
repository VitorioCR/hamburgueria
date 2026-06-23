package hamburgueria;

import java.util.Arrays;
import java.util.List;

/**
 * [COMPOSITE] Folha — representa um ingrediente individual no cardápio.
 * Não tem filhos, apenas retorna seu próprio conteúdo.
 * Obs: renomeado de Ingrediente para evitar conflito com IngredienteCache (Flyweight).
 */
public class Ingrediente implements ItemCardapio {

    private String nome;
    private double preco;

    public Ingrediente(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    @Override
    public List<String> listarItens() { return Arrays.asList(nome); }
}
