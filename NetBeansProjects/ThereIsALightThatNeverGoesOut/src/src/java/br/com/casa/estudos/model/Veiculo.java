/*
 * Copyright (C) 2018 Igor
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
package br.com.casa.estudos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 *
 * @author Igor
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long idVeiculo;
        
    @Column=nullable
    private String placa;
    
    @OneToOne
    private Marca marca;
    
    public Veiculo(){
        idVeiculo =- 1;        
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public void setMarca(Marca marca){
        this.marca = marca;
    }
    
    public Marca getMarca(){
        return marca;
    }
}
