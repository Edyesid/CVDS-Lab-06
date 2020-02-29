package edu.eci.cvds.GameGuess;

import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "guessBean")
@SessionScoped
public class BackingBean {
	private int intent;
	private int numeroAdivinar;
	private int intentos;
	private int premioAcumulado;
	private String estado;
	private ArrayList<Integer> numerosUsados = new ArrayList<Integer>();
	
	
	public BackingBean() {
		numeroAdivinar=(int) (Math.random() *10 ) + 1;
		intentos = 0;
		premioAcumulado = 100000;
		estado="Are you Ready?";
	}
	
	public void guess(int intento) {
		intento=intent;
		if(intent == numeroAdivinar && intentos==0) {
			estado = "Acerto";
		} else if (intent != numeroAdivinar) {
			estado = "all right";
			numerosUsados.add(intent);
			intentos++;
			premioAcumulado = premioAcumulado - (10000);
		}else if (intent == numeroAdivinar && intentos>=1) {
			estado = "Acertado";
			
		}
		if (premioAcumulado < 0) {
			premioAcumulado = 0;
		}
	}
	
	
	public void reiniciar() {
		numeroAdivinar=(int) (Math.random() *10 ) + 1;
		premioAcumulado = 100000;
		intentos = 0;
		estado="Are you Ready?";
		numerosUsados = new ArrayList<Integer>();
	}
	

	public int getIntent() {
		return intent;
	}

	public void setIntent(int intent) {
		this.intent = intent;
	}

	public ArrayList<Integer> getNumerosUsados() {
		return numerosUsados;
	}

	public void setNumerosUsados(ArrayList<Integer> numerosUsados) {
		this.numerosUsados = numerosUsados;
	}

	public int getNumeroAdivinar() {
		return numeroAdivinar;
	}
	public void setNumeroAdivinar(int numeroAdivinar) {
		this.numeroAdivinar = numeroAdivinar;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public int getPremioAcumulado() {
		return premioAcumulado;
	}
	public void setPremioAcumulado(int premioAcumulado) {
		this.premioAcumulado = premioAcumulado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
