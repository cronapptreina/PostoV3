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
@Repository("CarroDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface CarroDAO extends JpaRepository<Carro, java.lang.String> {

  /**
   * Obtém a instância de Carro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Carro entity WHERE entity.id = :id")
  public Carro findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Carro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Carro entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.carro.id = :id")
  public Page<Abastecimento> findAbastecimento(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.posto FROM Abastecimento entity WHERE entity.carro.id = :id AND (entity.posto.nome like concat('%',coalesce(:search,''),'%') OR entity.posto.cep like concat('%',coalesce(:search,''),'%') OR entity.posto.logradouro like concat('%',coalesce(:search,''),'%') OR entity.posto.bairro like concat('%',coalesce(:search,''),'%') OR entity.posto.cidade like concat('%',coalesce(:search,''),'%') OR entity.posto.uf like concat('%',coalesce(:search,''),'%'))")
  public Page<Posto> listPostoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.posto FROM Abastecimento entity WHERE entity.carro.id = :id AND (:nome is null OR entity.posto.nome like concat('%',:nome,'%')) AND (:cep is null OR entity.posto.cep like concat('%',:cep,'%')) AND (:logradouro is null OR entity.posto.logradouro like concat('%',:logradouro,'%')) AND (:bairro is null OR entity.posto.bairro like concat('%',:bairro,'%')) AND (:cidade is null OR entity.posto.cidade like concat('%',:cidade,'%')) AND (:uf is null OR entity.posto.uf like concat('%',:uf,'%'))")
  public Page<Posto> listPostoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="nome") java.lang.String nome, @Param(value="cep") java.lang.String cep, @Param(value="logradouro") java.lang.String logradouro, @Param(value="bairro") java.lang.String bairro, @Param(value="cidade") java.lang.String cidade, @Param(value="uf") java.lang.String uf, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.posto FROM Abastecimento entity WHERE entity.carro.id = :id")
  public Page<Posto> listPosto(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Abastecimento entity WHERE entity.carro.id = :instanceId AND entity.posto.id = :relationId")
  public int deletePosto(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.placa like concat('%',coalesce(:search,''),'%') OR entity.marca like concat('%',coalesce(:search,''),'%') OR entity.modelo like concat('%',coalesce(:search,''),'%')")
  public Page<Carro> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE (:placa is null OR entity.placa like concat('%',:placa,'%')) AND (:marca is null OR entity.marca like concat('%',:marca,'%')) AND (:modelo is null OR entity.modelo like concat('%',:modelo,'%'))")
  public Page<Carro> specificSearch(@Param(value="placa") java.lang.String placa, @Param(value="marca") java.lang.String marca, @Param(value="modelo") java.lang.String modelo, Pageable pageable);
  
  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM Carro entity WHERE entity.user.id = :id")
  public Page<Carro> findCarrosByUser(@Param(value="id") java.lang.String id, Pageable pageable);

}
