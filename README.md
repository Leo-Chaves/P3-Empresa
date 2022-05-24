# P3-Empresa
source git

 

O projeto é criação de uma código de um Site de venda de produtos, que tem a seguintes características(na ordem):

 

- A escolha se deseja entrar como é uma empresa ou um cliente

- independente do que escolher vai ter uma segunda aba que é: se deja fazer o login ou se deseja cadastrar

 

cadastro:

- Se cadastrar como empresa você deverá digitar o "nome da empresa", o "CNPJ da empresa", "DDD", "Telefone", "Saldo", e a "Senha"

- Se cadastrar como cliente você deverá digitar o "Nome", "CPF", "DDD", "Telefone", "Gênero","Código(qualquer) para adicionar amigos" e "Senha"

OBS1: o CPF tem um limite de 11 caracteres

 

Login:

- Para efetuar o login como empresa precisa digitar o "CNPJ" e a "Senha"

- Para efetuar o login como cliente precisa digitar o "nome" e "Senha" ""

OBS2: uma parte do código faz a busca para ver se digitou tudo corretamente, se estiver errado, é perguntado se deseja tentar novamente

 

Logado:

- Quando é logado na empresa tem as opções de "Adicionar o produto que gostaria de vender" ou "Altera dados da empresa"

- Quando é logado no cliente tem  as opções de Ver os "Produtos em Venda", "Comprar Token", " Para Amigos","Altera dados" ou "Sair"

 

Alterar Dados:

- As opções de alteração de dados da empresa são "Nome da Empresa", "Telefone", "CNPJ" e "Saldo"

- As opções de alteração de dados do cliente são "Nome", "Gênero", "Telefone" e "CPF"

 

Produto:

- Na empresa ao cadastrar o produto tem que digitar "Nome Do Produto", "Quantidade De produtos/Estoque", "Preço do Produto(em Token)" e "Código do produto"

- Os clientes vem os produtos que as empresas mostram na opção "Produtos em Venda"

 

Touken:

- é a moeda do site//app

 

Amigo Do Cliente:

- Na opção "para Amigos" tem a escolha de "Adicionar um amigo", "Remover um Amigo", "Enviar Token pro Amigo"

- Na escolha de adicionar um amigo Precisa usar o "Codigo para amizades"

- Na escolha de "Enviar Token Pro Amigo" você manda o dinheiro do site pro amigo

 

 

 

O Código Foi Organizado Em 3 pastas:

 

1) Controller(Contem 4 classes):

 

- Classe Cliente(Cliente.java); QUE É RESPONSÁVEL:

 

/*

Criação do Cliente(login, cadastro e busca) e atributos(nome, cpf, código amigo, senha, telefone etc...)

e a verificação do cliente(se existe no banco de dados)

Método depositar e sacar token (Cada token será igual a 1 real)

Método trocar informações do perfil do cliente

Método para envio de token para amigos

Método Desconto para clientes vip(herança do cliente caso ele compre o VIP(custo 100 tokens))

Método para exibir o histórico de compras

*/

 

- Classe Empresa(Empresa.Java); QUE É RESPONSÁVEL:

 

  /*

Criação da Empresa(login, cadastro e busca) e  atributos(nome, cnpj, ddd, telefone, senha etc...)

e a verificação da Empresa(se existe no banco de dados)

Método cadastrar produto(Classe Produto)

Método para exibir o lucro de vendas da empresa

 

*/

 

 

- Classe Menus(Menus.java); QUE É RESPONSÁVEL:

 

 

 /*

 Classe para armazenar todos os menus de exibição

*/

__

 

- Classe Produto(Produto.java); QUE É RESPONSÁVEL:

 

/*

Criação do Produto(métodos adicionar estoque, retirar estoque) e atributos(nome, preço, código, estoque)

*/

 

 

 

 

2) Model(Contém 1 classe);

 

 

- Classe Operações(Operações.java); QUE É RESPONSÁVEL:

 

 

/*

operações do cliente

*/

 

 

 

3) View(Contém 1 Classe Principal ):

 

 

- Classe Main(main.java); QUE É RESPONSÁVEL:

 

 

/*

 

Classe principal onde tem as "LISTAS DE CLIENTES/PRODUTOS/EMPRESA" que é interagido com as outras classes

 

*/