package hamburgueria;

/** [BRIDGE] Implementação concreta de Turno — turno da noite com adicional de 30%. */
public class TurnoNoite implements Turno {
    @Override
    public String getTurno() { return "Noite (22h-06h)"; }

    @Override
    public double getAdicionalSalario() { return 0.3; }
}
