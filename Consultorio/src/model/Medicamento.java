package model;

public class Medicamento {

    private int cod;
    private String nomeMed;
    private String descricao;

    public Medicamento() {

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static void adicionarMedicamentos() {
    }

    public static void visualizarMedicamentos() {
    }

}
