package hamburgueria;

/** [BRIDGE] Implementação concreta de Funcionario — cargo de Cozinheiro. */
public class Cozinheiro extends Funcionario {
    public Cozinheiro(String nome, double salarioBase, Turno turno) { super(nome, salarioBase, turno); }

    @Override
    public String getCargo() { return "Cozinheiro"; }
}
