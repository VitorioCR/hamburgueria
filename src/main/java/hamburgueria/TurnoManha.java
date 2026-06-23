package hamburgueria;

/** [BRIDGE] Implementação concreta de Turno — turno da manhã sem adicional. */
public class TurnoManha implements Turno {
    @Override
    public String getTurno() { return "Manhã (06h-14h)"; }

    @Override
    public double getAdicionalSalario() { return 0.0; }
}
