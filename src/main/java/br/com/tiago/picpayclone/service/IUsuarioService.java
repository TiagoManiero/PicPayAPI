package br.com.tiago.picpayclone.service;

import br.com.tiago.picpayclone.dto.UsuarioDTO;
import br.com.tiago.picpayclone.model.Transacao;
import br.com.tiago.picpayclone.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario consultarEntidade(String login);

    UsuarioDTO consultar(String login);

    void atualizarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito);

    void validar(Usuario... usuarios);

    List<UsuarioDTO> listar(String login);
}
