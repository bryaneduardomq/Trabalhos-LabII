package model;

import java.util.Calendar;

public class Consulta {

    private Calendar dataHora;
    private Paciente paciente;
    private Receituario receituario;

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public static void adicionarConsulta() {
    }

    public static void visualizarConsultas() {
    }

}
