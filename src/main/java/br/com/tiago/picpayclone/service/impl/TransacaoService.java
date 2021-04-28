package br.com.tiago.picpayclone.service.impl;


import br.com.tiago.picpayclone.conversor.TransacaoConversor;
import br.com.tiago.picpayclone.dto.TransacaoDTO;
import br.com.tiago.picpayclone.model.Transacao;
import br.com.tiago.picpayclone.repository.TransacaoRepository;
import br.com.tiago.picpayclone.service.ICartaoCreditoService;
import br.com.tiago.picpayclone.service.ITransacaoService;
import br.com.tiago.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class TransacaoService implements ITransacaoService {
    @Autowired
    private TransacaoConversor transacaoConversor;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ICartaoCreditoService cartaoCreditoService;

    @Override
    public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
        Transacao transacao = salvar(transacaoDTO);
        cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
        usuarioService.atualizarSaldo(transacao,transacaoDTO.getIsCartaoCredito());
        return transacaoConversor.converterEntidadeParaDto(transacao);
    }

    @Override
    public Page<TransacaoDTO> listar(Pageable paginacao, String login) {
        Page<Transacao> transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao);
        return transacaoConversor.converterPageEntidadeParaDto(transacoes);
    }

    private Transacao salvar(TransacaoDTO transacaoDTO){
        Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
        usuarioService.validar(transacao.getDestino(),transacao.getOrigem());
        return transacaoRepository.save(transacao);
    }
}
