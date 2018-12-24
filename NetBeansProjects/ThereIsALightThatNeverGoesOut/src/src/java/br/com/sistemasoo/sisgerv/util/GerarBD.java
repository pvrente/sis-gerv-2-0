/*
 * Copyright (C) 2018 Pablo Rangel <pablorangel@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.sistemasoo.sisgerv.util;

import br.com.sistemasoo.sisgerv.dao.DAO;
import br.com.sistemasoo.sisgerv.model.ItemPedido;
import br.com.sistemasoo.sisgerv.model.Pedido;
import br.com.sistemasoo.sisgerv.model.PessoaFisica;
import br.com.sistemasoo.sisgerv.model.Produto;

/**
 * Classe utilitária para testes com o banco de dados e inclusão de registros essenciais. 
 * 
 * @author Pablo Rangel <pablorangel@gmail.com>
 */
public class GerarBD {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Pablo");
        pf.setCpf("111.111.111-11");
        DAO acesso = new DAO(pf);
        acesso.inserir();

        
        Produto prod1 = new Produto();
        prod1.setNome("Playstation 4");
        prod1.setValor(1500);
        Produto prod2 = new Produto();
        prod2.setNome("X-Box");
        prod2.setValor(1100);
        
        acesso = new DAO(prod1);
        acesso.inserir();
        acesso = new DAO(prod2);
        acesso.inserir();
        
/*        Pedido ped1 = new Pedido ();
        
        ItemPedido item1 = new ItemPedido();
        item1.setProduto(prod1);
        item1.setQuantidade(2);
        item1.setPedido(ped1);
        
        ItemPedido item2 = new ItemPedido();
        item2.setProduto(prod2);
        item2.setQuantidade(3);
        item2.setPedido(ped1);
        
        ped1.adicionarItemPedido(item1);
        ped1.adicionarItemPedido(item2);
        
        ped1.setCliente(pf);

        acesso = new DAO(ped1);
        acesso.inserir();
  */    
      
        
    }
}
