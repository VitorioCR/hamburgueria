package hamburgueria;

/** [SINGLETON] Configuração global do restaurante — instância única garantida. */
public class ConfiguracaoRestaurante {

    private ConfiguracaoRestaurante() {}

    private static ConfiguracaoRestaurante instance = new ConfiguracaoRestaurante();

    public static ConfiguracaoRestaurante getInstance() {
        return instance;
    }

    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioFuncionamento;
    private String usuarioLogado;

    public String getNomeRestaurante() { return nomeRestaurante; }
    public void setNomeRestaurante(String nomeRestaurante) { this.nomeRestaurante = nomeRestaurante; }

    public String getEnderecoRestaurante() { return enderecoRestaurante; }
    public void setEnderecoRestaurante(String enderecoRestaurante) { this.enderecoRestaurante = enderecoRestaurante; }

    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }

    public String getUsuarioLogado() { return usuarioLogado; }
    public void setUsuarioLogado(String usuarioLogado) { this.usuarioLogado = usuarioLogado; }
}
