package hamburgueria;

/** [PROXY] Usuário privilegiado — verificado pelo PedidoProxy antes de liberar dados sensíveis. */
public class Gerente {

    private String nome;
    private boolean administrador;

    public Gerente(String nome, boolean administrador) {
        this.nome = nome;
        this.administrador = administrador;
    }

    public String getNome() { return nome; }
    public boolean isAdministrador() { return administrador; }
}
