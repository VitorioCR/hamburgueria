package hamburgueria;

/** [BRIDGE] Implementação concreta de Funcionario — cargo de Atendente. */
public class Atendente extends Funcionario {
    public Atendente(String nome, double salarioBase, Turno turno) { super(nome, salarioBase, turno); }

    @Override
    public String getCargo() { return "Atendente"; }
}
