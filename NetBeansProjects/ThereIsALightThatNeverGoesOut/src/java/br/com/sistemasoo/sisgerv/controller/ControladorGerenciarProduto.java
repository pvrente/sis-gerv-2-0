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

package br.com.sistemasoo.sisgerv.controller;

import br.com.sistemasoo.sisgerv.model.Produto;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Controlador do Caso de Uso "Gerenciar Produto".
 * @author Pablo Rangel <pablorangel@gmail.com>
 */
@ManagedBean
@SessionScoped
@Named(value = "controladorGerenciarProduto")
public class ControladorGerenciarProduto extends ControladorGerenciar<Produto>{
   public ControladorGerenciarProduto(){
       super(new Produto());
   }
}
