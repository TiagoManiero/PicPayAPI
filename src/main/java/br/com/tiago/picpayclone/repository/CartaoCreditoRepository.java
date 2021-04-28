package br.com.tiago.picpayclone.repository;

import br.com.tiago.picpayclone.model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
}
