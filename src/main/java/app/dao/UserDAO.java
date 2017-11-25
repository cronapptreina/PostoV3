package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("UserDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface UserDAO extends JpaRepository<User, java.lang.String> {

  /**
   * Obtém a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM User entity WHERE entity.id = :id")
  public User findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de User utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM User entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Role entity WHERE entity.user.id = :id")
  public Page<Role> findRole(@Param(value="id") java.lang.String id, Pageable pageable);
    
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.user.id = :id AND (entity.placa like concat('%',coalesce(:search,''),'%') OR entity.marca like concat('%',coalesce(:search,''),'%') OR entity.modelo like concat('%',coalesce(:search,''),'%'))")
  public Page<Carro> findCarroGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.user.id = :id AND (:placa is null OR entity.placa like concat('%',:placa,'%')) AND (:marca is null OR entity.marca like concat('%',:marca,'%')) AND (:modelo is null OR entity.modelo like concat('%',:modelo,'%'))")
  public Page<Carro> findCarroSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="placa") java.lang.String placa, @Param(value="marca") java.lang.String marca, @Param(value="modelo") java.lang.String modelo, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.user.id = :id")
  public Page<Carro> findCarro(@Param(value="id") java.lang.String id, Pageable pageable);

}
