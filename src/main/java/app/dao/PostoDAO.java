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
@Repository("PostoDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface PostoDAO extends JpaRepository<Posto, java.lang.String> {

  /**
   * Obtém a instância de Posto utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Posto entity WHERE entity.id = :id")
  public Posto findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Posto utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Posto entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


      
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id AND (:search = :search)")
  public Page<Abastecimento> findAbastecimentoGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id AND (:data is null OR entity.data = :data)")
  public Page<Abastecimento> findAbastecimentoSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="data") java.util.Date data, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Abastecimento entity WHERE entity.posto.id = :id")
  public Page<Abastecimento> findAbastecimento(@Param(value="id") java.lang.String id, Pageable pageable);
  
  /**
   * ManyToOne Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity.carro FROM Abastecimento entity WHERE entity.posto.id = :id AND (entity.carro.placa like concat('%',coalesce(:search,''),'%') OR entity.carro.marca like concat('%',coalesce(:search,''),'%') OR entity.carro.modelo like concat('%',coalesce(:search,''),'%'))")
  public Page<Carro> listCarroGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity.carro FROM Abastecimento entity WHERE entity.posto.id = :id AND (:placa is null OR entity.carro.placa like concat('%',:placa,'%')) AND (:marca is null OR entity.carro.marca like concat('%',:marca,'%')) AND (:modelo is null OR entity.carro.modelo like concat('%',:modelo,'%'))")
  public Page<Carro> listCarroSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="placa") java.lang.String placa, @Param(value="marca") java.lang.String marca, @Param(value="modelo") java.lang.String modelo, Pageable pageable);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.carro FROM Abastecimento entity WHERE entity.posto.id = :id")
  public Page<Carro> listCarro(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Abastecimento entity WHERE entity.posto.id = :instanceId AND entity.carro.id = :relationId")
  public int deleteCarro(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Posto entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.cep like concat('%',coalesce(:search,''),'%') OR entity.logradouro like concat('%',coalesce(:search,''),'%') OR entity.bairro like concat('%',coalesce(:search,''),'%') OR entity.cidade like concat('%',coalesce(:search,''),'%') OR entity.uf like concat('%',coalesce(:search,''),'%')")
  public Page<Posto> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Posto entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:cep is null OR entity.cep like concat('%',:cep,'%')) AND (:logradouro is null OR entity.logradouro like concat('%',:logradouro,'%')) AND (:bairro is null OR entity.bairro like concat('%',:bairro,'%')) AND (:cidade is null OR entity.cidade like concat('%',:cidade,'%')) AND (:uf is null OR entity.uf like concat('%',:uf,'%'))")
  public Page<Posto> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="cep") java.lang.String cep, @Param(value="logradouro") java.lang.String logradouro, @Param(value="bairro") java.lang.String bairro, @Param(value="cidade") java.lang.String cidade, @Param(value="uf") java.lang.String uf, Pageable pageable);
  
}
