package br.com.casadocodigo.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Path("livros")
public class LivroResource {

	@Inject
	private LivroDao dao;

	@GET
	@Path("lancamentos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Livro> ultimosLancamentosJson() {
		return dao.ultimosLancamentos();
	}

}
