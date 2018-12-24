
package br.com.sistemasoo.sisgerv.util;


import br.com.pqpltda.sisgerv.dao.DAO;
import br.com.pqpltda.sisgerv.model.ItemPedido;
import br.com.pqpltda.sisgerv.model.Pedido;
import br.com.pqpltda.sisgerv.model.Produto;
import br.com.sistemasoo.*;

public class GerarBD {
    
    public static void main(String[] args) {
        Produto prod1 = new Produto();
        prod1.setNome("Playstation 4");
        prod1.setPreco(1300f);
        
        Produto prod2 = new Produto();
        prod2.setNome("Xbox");
        prod2.setPreco(1100f);
        
       DAO<Produto> acesso = new DAO(prod1);
       acesso.inserir();
       acesso = new DAO(prod2);
       acesso.inserir();
       
       Pedido ped1 = new Pedido();
       Pedido ped2 = new Pedido();
       
       ItemPedido item1 = new ItemPedido();
       item1.setProduto(prod1);
       item1.setQuantidade(3);
       item1.setPedido(ped1);
       
       
       ItemPedido item2 = new ItemPedido();
       item2.setProduto(prod1);
       item2.setQuantidade(3);
       item2.setPedido(ped1);
       
       ped1.Adicionar(item1);
       ped1.Adicionar(item2);
       
       acesso = new DAO(ped1);
       acesso.inserir();
       
        
       ItemPedido item3 = new ItemPedido();
       item3.setProduto(prod2);
       item3.setQuantidade(1);
       item3.setPedido(ped2);
  
       ped2.Adicionar(item3);
       
       acesso = new DAO(ped2);
       acesso.inserir();

      
    }
}
