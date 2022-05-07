package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

import org.hibernate.service.spi.InjectService;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;


//@ApplicationScoped       //TODOS OS USUÁRIOS compartilham os mesmos dados
//@SessionScoped 	      Dados mantidos na sessão do usuário
@ViewScoped         //Lista Morre quando redireciona a tela
//@RequestScoped      Como quer adicionar em uma lista, o request que é de vida curta não serve
@ManagedBean(name = "pessoaBean")  //referencia o nome e não a classe java
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
		carregarPessoas();
		return "";
	}
	
	public String novo(){
		pessoa=new Pessoa();
		return "";
		
	}
	
	public String remove() {
		daoGeneric.deletePorId(pessoa);
		pessoa=new Pessoa();
		carregarPessoas();
		return "";
	}

	@PostConstruct
public void carregarPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
		
			
	
}
