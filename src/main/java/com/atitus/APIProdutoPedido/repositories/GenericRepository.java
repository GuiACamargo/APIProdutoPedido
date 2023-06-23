package com.atitus.APIProdutoPedido.repositories;

import com.atitus.APIProdutoPedido.entities.GenericEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity>
        extends JpaRepository<TEntidade, Long> {

    Page<TEntidade> findAll(Pageable pageable);
}
