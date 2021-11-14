package br.edu.usj.ads.pw.carros;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//<nome da entidade, tipo dela>
public interface CarroRepository extends CrudRepository<Carro, Long>{
    List<Carro> findAll();


}
