package P3.code.view;

import java.util.Scanner;
import java.util.LinkedList;
import controller.*;

class Main {

    // LISTAS DE CLIENTES/PRODUTOS/EMPRESA
    public static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    public static LinkedList<Empresa> empresas = new LinkedList<Empresa>();
    public static LinkedList<Produtos> produtos = new LinkedList<Produtos>();
  
    public static void main(String[] args) throws IllegalAccessException {
        Scanner in = new Scanner(System.in);
        int op, cl, opC, opCA, opADC, opE, opADE;
        do {
            menuInicial();
            op = in.nextInt();
            if (op == 1) {// CLIENTE
                do {
                    menuCL();
                    cl = in.nextInt();
                    if (cl == 1) {
                        boolean tfc = loginCliente();
                        if (tfc == true) {// Cliente entrou na conta
                            /* aqui estarão todas as opções do cliente */
                            do {
                                opcaoCliente();
                                opC = in.nextInt();
                                if (opC == 1) {
                                    // Exibir a lista de produtos cadastrados
                                } else if (opC == 2) {
                                    // Comprar tokens
                                } else if (opC == 3) {
                                    // Criar um menu novo com as opçoes relaciondas a amigos dentro de cliente
                                    do {
                                        menuClienteAmigo();
                                        opCA = in.nextInt();
                                        if (opCA == 1) {
                                            // adicionar um cliente
                                        } else if (opCA == 2) {
                                            // remover um amigo
                                        } else if (opCA == 3) {
                                            // enviar um token para amigo
                                        }
                                    } while (opCA != 0);
                                } else if (opC == 4) {
                                    // Alterar dados
                                    do {
                                        menuAlterarDadosCliente();
                                        opADC = in.nextInt();
                                        if (opADC == 1) {
                                            // alterar nome
                                        } else if (opADC == 2) {
                                            // alterar genero
                                        } else if (opADC == 3) {
                                            // alterar telefone
                                        } else if (opADC == 4) {
                                            // alterar cpf
                                        }
                                    } while (opADC != 0);
                                }
                            } while (opC != 0);
                        }
                    } else if (cl == 2) {// Opção de cadastrar
                        cadastroCliente();
                    } else {
                        System.out.println("Opção inválida...");
                        throw new IllegalAccessException("");
                    }
                } while (cl != 0);
                break;
            } else if (op == 2) {// EMPRESA
                do {
                    menuCL();
                    cl = in.nextInt();
                    if (cl == 1) {
                        boolean tfe = loginEmpresa();
                        if (tfe == true) {// Empresa entrou na conta
                            /* aqui estarão todas as ações da empresa */
                            do{
                            opcaoEmpresa();
                            opE = in.nextInt();
                            if(opE == 1){
                                //adicionar um produto no catalogo
                              cadastroProduto();

                              
                            }else if(opE == 2){
                                //para alterar seus dados
                                do{
                                menuAlterarDadosEmpresa();
                                opADE = in.nextInt();
                                if(opADE == 1){
                                    //alterar nome empresa
                                }else if(opADE == 2){
                                    //alterar telefone empresa
                                }else if(opADE == 3){
                                    //alterar cnpj empresa
                                }else if(opADE == 4){
                                    //alterar saldo empresa
                                }
                                }while(opADE != 0);
                            }        
                            }while(opE != 0);
                        }
                    } else if (cl == 2) {// Opção de cadastrar
                        cadastroEmpresa();
                    } else {
                        System.out.println("Opção inválida...");
                        throw new IllegalAccessException("");
                    }
                } while (cl != 0);
                break;
            } else if (op == 0) {
                System.out.println("ENCERRANDO...");
            } else {
                System.out.println("Opção inválida...");
                throw new IllegalAccessException("");
            }
        } while (op != 0);

    }

    public static void menuInicial() {
        System.out.println("Menu");
        System.out.println("Deseja iniciar sessão como cliente ou empresa?");
        System.out.println("[1] para cliente");
        System.out.println("[2] para empresa");
        System.out.println("[0] para encerrar");
        System.out.print("Digite:");
    }

    public static void menuCL() {// Menu cadastro ou login
        System.out.println("Deseja logar ou cadastrar?");
        System.out.println("[1] para logar");
        System.out.println("[2] para cadastrar");
        System.out.print("Digite:");
    }

  
    public static boolean loginCliente() {
        Scanner in = new Scanner(System.in);
        boolean retorno;
        do {
            System.out.println("Digite");
            System.out.print("Nome: ");
            String nome = in.next();
            System.out.print("Senha: ");
            String senha = in.next();
            retorno = buscaLoginCliente(nome, senha);
            if (retorno == false) {// Aqui ele da a escolha para tentar fazer login novamente
                System.out.println("Login inválido... Deseja tentar denovo?");
                System.out.println("Digite [1] para sim,[2] para não: ");
                int a = in.nextInt();
                if (a == 2) {
                    break;
                }
            }
        } while (retorno != true);
        return retorno;
    }

    public static void cadastroCliente() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe seu nome: ");
        String nome = in.nextLine();

        System.out.print("Informe seu CPF (apenas números): ");
        String cpf = in.next();
        while (cpf.length() != 11) {// CPF tem que ter 11 dígitos
            System.out.print("CPF incorreto, digite novamente (apenas números, 11 numeros): ");
            cpf = in.next();
        }

        System.out.print("Informe seu DDD: ");
        String ddd = in.next();
        System.out.println("Informe seu número de telefone: ");
        String numc = in.next();
        String telefone = "(" + ddd + ")" + numc;

        System.out.print("Informe seu gênero: ");
        String genero = in.next();

        System.out.print("Crie um Code para adicionar amigos: ");
        String code = in.next();

        System.out.print("Informe uma senha: ");
        String senha = in.next();

        boolean cd = verificarCD(cpf, senha);// verificando se já existe conta utilizando esse cpf ou senha
        if (cd == false) {
            Cliente cliente = new Cliente(code, nome, genero, telefone, cpf, senha);// Criou novo cliente
            clientes.add(cliente);// adicionou novo cliente a lista
            System.out.println("Conta criada com sucesso! Seja bem-vindo " + nome);
        } else {
            System.out.println("CPF ou Senha já existente. Conta não criada...");
        }
    }

    public static boolean loginEmpresa() {
        Scanner in = new Scanner(System.in);
        boolean retorno;
        do {
            System.out.println("Digite");
            System.out.print("CNPJ: ");
            String cnpj = in.next();
            System.out.print("Senha: ");
            String senha = in.next();
            retorno = buscaLoginEmpresa(cnpj, senha);
            if (retorno == false) {// Aqui ele da a escolha para tentar fazer login novamente
                System.out.println("Login inválido... Deseja tentar denovo?");
                System.out.println("Digite [1] para sim,[2] para não: ");
                int a = in.nextInt();
                if (a == 2) {
                    break;
                }
            }
        } while (retorno != true);
        return retorno;
    }

    public static void cadastroEmpresa() {
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o nome da empresa: ");
        String nome = in.next();

        System.out.print("Informe o CNPJ da empresa (apenas números): ");
        String cnpj = in.next();
        while (cnpj.length() != 14) {// CNPJ tem que ter 14 dígitos
            System.out.print("CNPJ incorreto, digite novamente (apenas números, 14 numeros): ");
            cnpj = in.next();
        }

        System.out.print("Informe o DDD: ");
        String ddd = in.next();
        System.out.println("Informe o número de telefone: ");
        String numc = in.next();
        String telefone = "(" + ddd + ")" + numc;

        System.out.print("Informe o saldo da empresa: ");
        double saldo = in.nextDouble();

        System.out.print("Informe uma senha: ");
        String senha = in.next();

        Empresa empresa = new Empresa(nome, telefone, cnpj, saldo, senha);// Criou nova empresa
        empresas.add(empresa);// Adiciona a lista de empresas
        System.out.println("Empresa cadastrada com sucesso!");
    }


  // ↓ ↓ ↓ ↓  tentativa de cadastrar produto    ↓ ↓ ↓ ↓    //
  
    public static void cadastroProduto(){
     Scanner in = new Scanner(System.in);
      System.out.print("Informe o nome do produto que deseja vender: ");
      String nome = in.next();

      System.out.print("Informe a quntidade de produto que deseja vender: ");
     int estoque = in.nextInt();

    System.out.print("Informe o preço do produto que deseja vender: ");
     double preco = in.nextDouble();

    System.out.print("digite o codigo para o produto: ");
       String codigo = in.next();

       Produto produto = new Produto(nome, estoque, preco,codigo);// Criou um novo produto
        produto.add(produto);// Adiciona a lista de Produto
        System.out.println("Produto Cadastrado Com Sucesso!");
      
    }

  //  ↑↑↑↑   tentativa de cadastrar produto ↑↑↑↑     //

  
    public static void opcaoCliente() {
        System.out.println("Menu");
        System.out.println("[1] para ver os produtos");
        System.out.println("[2] para comprar Tokens");
        System.out.println("[3] para amigos");// criar um novo menu para as opçoes relacionadas aos amigos
        System.out.println("[4] para alterar seus dados");
        System.out.println("[0] para Sair!");
        System.out.print("Digite:");
    }

    public static void menuClienteAmigo() {
        System.out.println("Menu");
        System.out.println("[1] para adicionar um amigo");
        System.out.println("[2] para remover um amigo");
        System.out.println("[3] para enviar um Token para um amigo");
        System.out.println("[0] para Voltar!");
    }

    public static void menuAlterarDadosCliente() {
        System.out.println("Menu");
        System.out.println("[1] para alterar seu nome");
        System.out.println("[2] para alterar seu genero");
        System.out.println("[3] para alterar seu telefone");
        System.out.println("[4] para alterar seu cpf");
        System.out.println("[0] para Voltar!");
    }
    
    public static void opcaoEmpresa(){
        System.out.println("Menu");
        System.out.println("[1] para adicionar um novo produto");
        System.out.println("[2] para alterar seus dados");
        System.out.println("[0] para Sair!");
    }
    
    public static void menuAlterarDadosEmpresa() {
        System.out.println("Menu");
        System.out.println("[1] para alterar seu nome");
        System.out.println("[2] para alterar seu telefone");
        System.out.println("[3] para alterar seu cnpj");
        System.out.println("[4] para alterar seu saldo");
        System.out.println("[0] para Voltar!");
    }

    public static boolean buscaLoginCliente(String nome, String senha) {
        // Metodo para buscar na lista de cliente para fazer login
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getNome().equalsIgnoreCase(nome) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public static boolean buscaLoginEmpresa(String cnpj, String senha) {
        /*
         * Metodo para buscar na lista de empresa para fazer login
         * (Apesar de apenas ter uma empresa criando a lista facilita)
         */
        for (int i = 0; i < empresas.size(); i++) {
            Empresa aux = empresas.get(i);
            if (aux.getCnpj().equals(cnpj) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return true;
    }

    public static boolean verificarCD(String cpf, String senha) {
        // Metodo para buscar cliente ja existente
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getCpf().equals(cpf) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}