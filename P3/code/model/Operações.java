package model;

import controller.Cliente;

public interface Operações{

  public void envioAmigo(Cliente cliente, Cliente amigo,int envio,  String codeFriend);

  public void CompraCliente(Cliente cliente, int compra); 
}