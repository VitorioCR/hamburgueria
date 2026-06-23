package hamburgueria;

/** [PROTOTYPE] Hambúrguer clonável — cópia exata sem recriar o objeto do zero. */
public class Hamburguer implements Cloneable {

    private String nome;
    private String pao;
    private String carne;
    private String molho;
    private boolean temQueijo;
    private boolean temBacon;
    private boolean temAlface;
    private boolean temTomate;

    public Hamburguer() {
        this.nome = "";
        this.pao = "Pão brioche";
        this.carne = "Hambúrguer bovino 180g";
        this.molho = "Molho especial";
        this.temQueijo = false;
        this.temBacon = false;
        this.temAlface = true;
        this.temTomate = true;
    }

    @Override
    public Hamburguer clone() {
        try {
            return (Hamburguer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPao() { return pao; }
    public void setPao(String pao) { this.pao = pao; }

    public String getCarne() { return carne; }
    public void setCarne(String carne) { this.carne = carne; }

    public String getMolho() { return molho; }
    public void setMolho(String molho) { this.molho = molho; }

    public boolean isTemQueijo() { return temQueijo; }
    public void setTemQueijo(boolean temQueijo) { this.temQueijo = temQueijo; }

    public boolean isTemBacon() { return temBacon; }
    public void setTemBacon(boolean temBacon) { this.temBacon = temBacon; }

    public boolean isTemAlface() { return temAlface; }
    public void setTemAlface(boolean temAlface) { this.temAlface = temAlface; }

    public boolean isTemTomate() { return temTomate; }
    public void setTemTomate(boolean temTomate) { this.temTomate = temTomate; }

    @Override
    public String toString() {
        return "Hamburguer{nome='" + nome + "', pao='" + pao + "', carne='" + carne +
                "', molho='" + molho + "', queijo=" + temQueijo + ", bacon=" + temBacon +
                ", alface=" + temAlface + ", tomate=" + temTomate + '}';
    }
}
