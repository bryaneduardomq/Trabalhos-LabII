package br.com.bryan.senac.classes;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.bryan.senac.menus.MenuVoo;

public class Voo {
	private String origem;
	private String destino;
	private String horario;
	private Aviao aviao;
	private static ArrayList<Voo> voos = new ArrayList<Voo>();

	public Voo() {

	}

	public Voo(String origem, String destino, String horario) {
		this.origem = origem;
		this.destino = destino;
		this.horario = horario;

	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@SuppressWarnings("static-access")
	public static void cadastrarVoo(ArrayList<Aviao> avioes) {
		Voo v = new Voo();
		MenuVoo mv = new MenuVoo();

		v.origem = digita("Digite a origem do voo: ");
		v.destino = digita("Digite o destino do voo: ");
		v.horario = digita("Digite o horário do voo: ");

		int cod = Integer.parseInt(digita("Digite o código do avião deste voo: "));

		for (int i = 0; i < avioes.size(); i++) {
			if (cod == avioes.get(i).getCodigo()) {
				v.aviao = avioes.get(i);
				voos.add(v);
			} else {
				System.out.println("Avião não cadastrado");
				mv.menuVoo();
			}
		}

	}

	@SuppressWarnings("static-access")
	public static void visualizarVoo() {
		MenuVoo mv = new MenuVoo();

		if (voos.isEmpty()) {
			System.out.println("Nenhum Voo Cadastrado!!!");
			mv.menuVoo();
		} else {
			for (Voo v : voos) {
				System.out.println("Origem: " + v.getOrigem());
				System.out.println("Destino: " + v.getDestino());
				System.out.println("Horário: " + v.getHorario());
				System.out.println("Avião: " + v.aviao);
				System.out.println();
			}
			mv.menuVoo();
		}
	}

	private static String digita(String mens) {
		@SuppressWarnings("resource")
		Scanner e = new Scanner(System.in);
		System.out.println(mens);
		return e.next();
	}

}
