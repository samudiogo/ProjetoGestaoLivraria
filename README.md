# Projeto Gestao Livraria 
Execício de trabalho de faculdade

1) Crie um banco e a tabela de usuário de acordo com as características existentes nas classes do projeto
	Veja a classe de conexão para saber o nome do banco e veja a classe dao do usuário para saber as informações da tabela.

2) Teste se a conexão está funcionando
	Veja na classe de teste de conexão!
	
3) Faça os demais testes antes mesmo de executar o projeto web	

#cadastramento de livros

Na tela cadastro.jsp, vamos criar um botão "livros" que nos leve para uma outra tela (listaLivros.jsp).

Inicialmente, essa tela trará uma listagem de todos os livros disponíveis existentes no banco.

Além dessa listagem, essa tela terá 
um botão "novo" que nos leva para a tela "detalheLivro.jsp" e 
um botão "associar" que nos leva para a tela "associaLivro.jsp"

#vamos trabalhar na tela de detalhe do livro
Nessa tela de detalhe teremos duas caixas de texto (nome e quantidade) para incluir as informações do livro.
É necessário criar uma classe de negócio, de dao e um servlet para fazer a manutenção do livro.

#troca de telas
Toda a troca de telas a partir do botão "livros" fica sob gestão do servlet "ControlaLivro".
