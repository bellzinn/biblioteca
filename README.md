# Biblioteca

## Descrição:
  O sistema de gerenciamento de empréstimos de livros em Java é uma solução abrangente projetada para modernizar e otimizar as operações de bibliotecas, este sistema oferece uma gama de opções tanto para admins da biblioteca como também para os usuarios dela.A interação dos usuarios deste sistema se dá através de telas SWING para oferecer uma experienciar melhor do que na linha de comando.
  

## Requisitos:
Java Development Kit (JDK) 8 ou superior;
Banco de dados MySQl;
IDE Eclipse (ou qualquer outra IDE de sua escolha).


## Passo a passo:


### Configuração do Ambiente
  Instalação do Eclipse: Se o usuário ainda não tiver o Eclipse instalado,ele pode ser baixado no site oficial e seguir as instruções de instalação para o seu sistema operacional: https://eclipseide.org/

  Instalação do MySQL: O usuário precisa ter o MySQL instalado em sua máquina,o MySQL pode ser baixado a partir do site oficial e seguir as instruções de instalação: https://www.mysql.com/

  Configuração do Banco de Dados: importe os dados das tabelas com o arquivos CSV correspodentes a elas,a tabela "editora" vai importar o arquivo "editora.csv" e assim por diante.



### Importação do Projeto no Eclipse
  Abra o Eclipse: Inicie o Eclipse IDE em sua máquina.
    
  Importe o Projeto: Vá em "File" > "Import..." e escolha "Existing Projects into Workspace". Selecione o diretório onde está o projeto que contém o código a ser utilizado.



## Configuração do Banco de Dados no Código
  Configuração do Driver JDBC: Certifique-se de que o driver JDBC do MySQL está incluído no projeto. Caso contrário, o usuário precisará adicioná-lo ao classpath do projeto.

  Configuração das Credenciais do Banco de Dados: acesse a classe "conexao" dentro do pacote "sql.biblioteca" e então mude o "user" e o "password" que estão la para o usuario e senha do seu servidor.
