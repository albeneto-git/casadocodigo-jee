package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.dao.AutorDao;
import br.com.casadocodigo.loja.dao.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;
	
	private List<Integer> autoresId = new ArrayList<Integer>();
	
	
	
	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	private Livro livro = new Livro();

	
	
	public List<Autor> getAutores(){
		return autorDao.listar();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	@Transactional
	public String salvar() {
		System.out.println("Livro cadastrado " + livro);
		for (Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		
		livroDao.salvar(livro);
		
		return "/livros/lista?faces-redirect=true";
	}
}
