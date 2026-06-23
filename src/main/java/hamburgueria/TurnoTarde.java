package hamburgueria;

/** [BRIDGE] Implementação concreta de Turno — turno da tarde com adicional de 10%. */
public class TurnoTarde implements Turno {
    @Override
    public String getTurno() { return "Tarde (14h-22h)"; }

    @Override
    public double getAdicionalSalario() { return 0.1; }
}
