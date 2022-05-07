package br.com.teste;

import javax.persistence.Persistence;




//CRIAR A TABELA PESSOA - RUN AS COM JAVA APLICATION
public class TesteJPA {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("projetojsf");   //nome que declarou no campo 'name' no arquivo persistence
		
	}

}
