package br.com.tiago.picpayclone.service.impl;

import br.com.tiago.picpayclone.conversor.CartaoCreditoConversor;
import br.com.tiago.picpayclone.dto.CartaoCreditoDTO;
import br.com.tiago.picpayclone.model.CartaoCredito;
import br.com.tiago.picpayclone.repository.CartaoCreditoRepository;
import br.com.tiago.picpayclone.service.ICartaoCreditoService;
import br.com.tiago.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartaoCreditoService implements ICartaoCreditoService {
    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCredito.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }

        return cartaoCreditoRetorno;
    }
}
