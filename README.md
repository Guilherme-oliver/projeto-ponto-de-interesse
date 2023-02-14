# projeto-ponto-de-interesse

Aplicação desenvolvida em Java(19) + Spring Boot(3.0.2) em suas versões lts;

Ferramentas:

*Intellij: Usado para desenvolver a aplicação em Java na sua versão lts, versão community.
Foi escolhido essa ferramenta por causa da sua facilidade e uso no desenvolvimento, ela também é capaz de baixar, aplicar e faz
o path sem a necessidade de fazer isso manualmente;

*Postman: Ferramenta de teste da aplicação, onde ela faz o consumo dos Endpoints do backEnd e testa a funcionalidade da aplicação,
foi usada essa ferramenta por causa da familiaridade do desenvolvedor, mas também foi adicionado o Swagger para a documentação da aplicação;

*Maven: Gerenciador de dependências usado na aplicação, consagrada no mercado e é de facíl acesso e manutenção; 

Como executar o projeto em uma nova máquina:

Baixe o projeto via GitHub, baixe as ferramentas Intellij e Postman, faça a importação do projeto no Intellij, execute o programa na parte superior da ferramenta.
No Postman, crie uma conta, após a criação da conta, em "Get started with Postman", clique em Creat New, escolha HTTP Request,
na aba de colecionaveis, adicione uma nova aba, o nome é de sua escolha.
Adicione o tipo de requisição Get, passe o caminho como localhost:8080/ponto-de-interesse, assim ira fazer a lista de todos os pontos de interesse.
Ainda no tipo Get, coloque no caminho localhost:8080/ponto-de-interesse/1, e você ira fazer a requisição dos pontos de interrese com o Id 1;
Fazendo a procura por nome, faça o caminho localhost:8080/ponto-de-interesse/nome/ , após a última barra, adicione o nome de seu interesse,
se houver um objeto com esse novo, ele ira retornar esse objeto;
Foi adicionado tanto a deleção quanto a atualização dos objetos, seguindo pelo caminho localhost:8080/ponto-de-interesse/ , usando o Id como referência,
é igual a procura por Id, mudando apenas se é para deletar ou atualizar o objeto, não esqueça de colocar o número do Id após a última barra;
