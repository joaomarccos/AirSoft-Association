package io.github.joaomarccos.pos.airsoft.repositories.interfaces;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 * @param <T>
 */
public interface Repository<T> {

    /**
     * Salva um objeto
     * @param entity 
     */
    public void save(T entity);

    /**
     * Exclui um objeto
     * @param entity 
     */
    public void delete(T entity);

    /**
     * Atualiza um objeto
     * @param entity 
     */
    public void update(T entity);        
        
}
