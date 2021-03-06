package br.com.casadocodigo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.models.Promo;
import br.com.casadocodigo.loja.websockts.PromosEndPoint;

@Model
public class AdminPromosBean {

	private Promo promo = new Promo();

	@Inject
	private PromosEndPoint promos;
	
	public void enviar() {
		promos.send(promo);
	}
	
	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

	
	
}
