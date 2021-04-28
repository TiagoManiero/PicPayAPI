package br.com.tiago.picpayclone.service;

import br.com.tiago.picpayclone.dto.TransacaoDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ITransacaoService {

    TransacaoDTO processar(TransacaoDTO transacaoDTO);

    Page<TransacaoDTO> listar(Pageable paginacao, String login);
}
