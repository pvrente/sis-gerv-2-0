
package br.com.pqpltda.sisgerv.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPedido;
    
    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
    private List <ItemPedido> itens;
    
    public Pedido(){
        itens = new ArrayList();
    }
    
    public long getIdPedido(){
        return idPedido;
    }
    
    public void setIdPedido(long idPedido){
        this.idPedido = idPedido;
    }
    
    public void Adicionar(ItemPedido item){
        itens.add(item);
    }
  
}
