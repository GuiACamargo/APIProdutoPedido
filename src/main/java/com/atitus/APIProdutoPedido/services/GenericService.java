package com.atitus.APIProdutoPedido.services;

import com.atitus.APIProdutoPedido.entities.GenericEntity;
import com.atitus.APIProdutoPedido.repositories.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<TEntidade extends GenericEntity> {
    GenericRepository<TEntidade> getRepository();

    default TEntidade save(TEntidade entidade) throws Exception {
        return getRepository().save(entidade);
    }

    default Optional<TEntidade> findById(long id) throws Exception{
        if (!getRepository().existsById(id))
            throw new Exception("Esse ID não está relacionado a algo no banco de dados");
        return getRepository().findById(id);
    }

    default Page<TEntidade> findAll(Pageable pageable) throws Exception{
        return getRepository().findAll(pageable);
    }


    default void deleteById(long id) {
        getRepository().deleteById(id);
    }
}
