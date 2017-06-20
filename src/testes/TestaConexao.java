package testes;

import conexao.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
		
		System.out.println(Conexao.obterConexao() != null ? "Conectado" : "Problemas!!! Verifique.");
		
	}
}
