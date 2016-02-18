package io.github.joaomarccos.pos.airsoft.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author João Marcos F
 * @param <T>
 */
public interface DAO<T> {

    public boolean save(T obj);

    public boolean update(T obj);

    public boolean delete(T obj);

    public T find(Object key, Class<T> entity);

    /**
     * Recupera uma lista de objetos a partir de uma consulta dinâmica (namedQuery)
     * @param namedQuery - Nome da consulta nomeada
     * @param params - parâmetros para consulta
     * @return lista de objetos do tipo T
     */
    public List<T> listQuery(String namedQuery, Map<String, Object> params);

    /**
     * Recupera um objeto a partir de uma consulta dinâmica (namedQuery)
     * @param namedQuery - Nome da consulta nomeada
     * @param params - parâmetros da consulta
     * @return objeto do tipo T
     */
    public T simpleQuery(String namedQuery, Map<String, Object> params);

}
