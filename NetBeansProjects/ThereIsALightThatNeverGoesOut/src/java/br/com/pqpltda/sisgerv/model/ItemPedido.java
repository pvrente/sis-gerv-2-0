
package br.com.pqpltda.sisgerv.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idItemPedido;
    
    @ManyToOne
    private Produto produto;
    
    @ManyToOne
    private Pedido pedido;
    
    private int quantidade;
    
    public ItemPedido(){
        
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public long getIdItemPedido(){
        return idItemPedido;
    }
    
    public void setPedido(Pedido npedido){
        pedido = npedido;
    }
    
    public void setIdItemPedido(long idItemPedido){
        this.idItemPedido = idItemPedido;
    }

    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   
    public int getQuantidade() {
        return quantidade;
    }

   
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
