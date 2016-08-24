# ConcisoIT
WebAPP Desenvolvido como parte do processo de seleção para estagiário

##Objetivo
Criar CRUD básico de cadastro de ônibus, linha de ônibus e paradas de ônibus, sabendo que:
um ônibus pertence a 1 linha;
uma parada pertence a N linhas;
uma linha pertence a N paradas;

##Metodologia de Desenvolvimento
Para a implementação desse projeto foi usado um banco de dados mysql e uma web application desenvolvida em java.

A web Application contem 4 pacotes, sendo eles:
1. Model: onde são implementadas as classes ônibus, parada, rota e relação(dado que a relação parada:rota é do tipo n:n).
2. DBUtils: onde é implementada a classe que cria a conexão da web application com o banco de dados.
3. DAO: onde são implementados as classes que fazem a interface entre a conexão e os objetos do banco.
4. Controller: onde são implementados os servlets usados para gerar as paginas web.

