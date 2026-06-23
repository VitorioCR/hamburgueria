package hamburgueria;

/** [BRIDGE] Abstração de implementação — contrato de turno desacoplado do funcionário. */
public interface Turno {
    String getTurno();
    double getAdicionalSalario();
}
