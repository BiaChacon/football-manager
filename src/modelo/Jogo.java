package modelo;

public class Jogo {

    private int id;
    private String dataHoraPartida;
    private String localJogo, adversario, competicao;
    private double lucroPartida;
    private boolean concluida;
    private boolean stCouF;

    public Jogo(int id, String dataHoraPartida, String localJogo, String adversario, String competicao, double lucroPartida, boolean concluida, boolean stCouF) {
        this.id = id;
        this.dataHoraPartida = dataHoraPartida;
        this.localJogo = localJogo;
        this.adversario = adversario;
        this.competicao = competicao;
        this.lucroPartida = lucroPartida;
        this.concluida = concluida;
        this.stCouF = stCouF;
    }

    public Jogo(String dataHoraPartida, String localJogo, String adversario, String competicao, boolean concluida, boolean stCouF) {
        this.dataHoraPartida = dataHoraPartida;
        this.localJogo = localJogo;
        this.adversario = adversario;
        this.competicao = competicao;
        this.concluida = concluida;
        this.stCouF = stCouF;
    }

    public Jogo(double lucroPartida, boolean concluida) {
        this.lucroPartida = lucroPartida;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public double getLucroPartida() {
        return lucroPartida;
    }

    public void setLucroPartida(double lucroPartida) {
        this.lucroPartida = lucroPartida;
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public String getLocalJogo() {
        return localJogo;
    }

    public void setLocalJogo(String local) {
        this.localJogo = local;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getCompeticao() {
        return competicao;
    }

    public void setCompeticao(String competicao) {
        this.competicao = competicao;
    }

    public boolean isStCouF() {
        return stCouF;
    }

    public void setStCouF(boolean stCouF) {
        this.stCouF = stCouF;
    }
}
