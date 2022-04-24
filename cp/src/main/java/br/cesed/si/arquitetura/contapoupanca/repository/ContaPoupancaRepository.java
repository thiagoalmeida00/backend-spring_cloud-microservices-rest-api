package br.cesed.si.arquitetura.contapoupanca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cesed.si.arquitetura.contapoupanca.entidade.ContaPoupanca;

@Repository
public interface ContaPoupancaRepository extends JpaRepository<ContaPoupanca, Long>{

}
