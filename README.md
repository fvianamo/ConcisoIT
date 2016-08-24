# ConcisoIT
WebAPP Desenvolvido como parte do processo de seleção para estagiário na ConcisoTI.

##Objetivo
Criar CRUD básico para cadastro de ônibus, linha de ônibus e paradas de ônibus, sabendo que:
um ônibus pertence a 1 linha,
uma parada pertence a N linhas e
uma linha pertence a N paradas.
Além disso, as paradas de ônibus deveriam ser exibidas em um map, com a descrição de quais linhas passam pela parada clicada.

##Metodologia de Desenvolvimento
Para a implementação desse projeto foi usado um banco de dados mysql e uma web application desenvolvida em java.

A web Application contem 4 pacotes, sendo eles:

1. Model: onde são implementadas as classes ônibus, parada, rota e relação(dado que a relação parada:rota é do tipo n:n).

2. DBUtils: onde é implementada a classe que cria a conexão da web application com o banco de dados.
 
3. DAO: onde são implementados as classes que fazem a interface entre a conexão e os objetos do banco.

4. Controller: onde são implementados os servlets usados para gerar as paginas web.

##Experiência
Inicialmente tive uma certa dificuldade para escolher as linguagens e ferramentas que iria utilizar pra esse projeto. Para o banco de dados tentei utilizar JavaBD e mySQL, acabei optando por mySQL. Para o desenvolvimento da web application java foi a escolha inicial dado minha experiência prévia com a linguagem. O problema realmente apareceu quando tentei gerar a paginas web. Em um primeiro ponto tentei usar JSP, infelizmente não tive muito sucesso. Após alguns bons dias tentando entender o JSP e implementar as paginas webs, decidi gerar os html diretamente dos servlets. Com essa estrategia consegui avançar, mas novos problemas surgiram.

##Resultado
A web Application desenvolvida é capaz de acessa e manipular o banco de dados, apenas a função de adicionar itens ao banco de dados foi implementada, pois um bug foi descoberto na pagina que exibia o conteúdo presente no banco de dados. Por algum motivo que não consegui identificar, a pagina exibi multiplas vezes (tamanho da tabela) o último elemento adicionado aquela tabela.
Os servlets que implementariam as funções de remover e atualizar valores do banco de dados seriam desenvolvidas seguindo o padrão do servlet de adição de elementos.
A respeito do uso da API do googleMaps, fui capaz de exibir um mapa contendo um pinpoint em uma das páginas iniciais e acredito que, caso o bug da listagem fosse resolvido, eu seria capaz de implementar a função requisitada.

