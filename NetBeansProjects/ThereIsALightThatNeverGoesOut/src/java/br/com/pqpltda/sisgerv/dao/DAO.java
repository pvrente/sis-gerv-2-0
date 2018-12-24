/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pqpltda.sisgerv.dao;

import br.com.pqpltda.sisgerv.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * Esta classe implementa um DAO (Data Access Object - GenÃ©rico) para conexÃ£o ao
 * Banco de Dados.
 *
 * @since 20/05/2016
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @param <T> tipo genÃ©rico para as classes de modelo a serem persistidas.
 */
public class DAO<T> {

    private T objetoModelo;

    public DAO(T objetoModelo) {
        this.objetoModelo = objetoModelo;
    }

    public T getObjetoModelo() {
        return objetoModelo;
    }

    public void setObjetoModelo(T objetoModelo) {
        this.objetoModelo = objetoModelo;
    }

    public void inserir() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.save(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao incluir registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public void alterar() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.update(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao incluir alterar: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public void excluir() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.delete(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao excluir registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public List<T> getList() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<T> list = null;
        try {
            s.getTransaction().begin();
            Criteria criteria = s.createCriteria(getObjetoModelo().getClass());
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            list = criteria.list();

        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registros (lista): " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }

        return list;
    }

    public void buscar(long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.load(getObjetoModelo(), id);
        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public List executarConsultaPersonalizada(String sql) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List data = null;
        try {
            s.getTransaction().begin();
            SQLQuery query = s.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registros: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
        return data;
    }
}

