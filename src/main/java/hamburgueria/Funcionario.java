package hamburgueria;

/** [BRIDGE] Abstração — Funcionario delega para Turno (implementação) sem acoplar as duas hierarquias. */
public abstract class Funcionario {

    protected String nome;
    protected double salarioBase;
    protected Turno turno;

    public Funcionario(String nome, double salarioBase, Turno turno) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.turno = turno;
    }

    public abstract String getCargo();

    public String getNome() { return nome; }

    public double getSalario() {
        return salarioBase + (salarioBase * turno.getAdicionalSalario());
    }

    public String getTurno() { return turno.getTurno(); }

    @Override
    public String toString() {
        return getCargo() + " " + nome + " | Turno: " + getTurno() + " | Salário: R$" + getSalario();
    }
}
