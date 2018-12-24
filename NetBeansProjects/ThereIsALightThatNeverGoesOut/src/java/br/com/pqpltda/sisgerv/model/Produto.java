
package br.com.pqpltda.sisgerv.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idProduto;
        private String nome;
        private float preco;
    
       public Produto(){
        
        
       }
        
       public void setidProduto(long idProduto){
            this.idProduto = idProduto;
        }

       public void setNome(String nome){
            this.nome = nome;
        }

       public void setPreco(float preco){
            this.preco = preco;
       }

       public long getIdProduto(){
           return idProduto;
       }
       
       public String getNome(){
           return nome;
       }
       
       public float getPreco(){
           return preco;
       }
       
}
