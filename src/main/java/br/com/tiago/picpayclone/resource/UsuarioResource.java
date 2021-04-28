package br.com.tiago.picpayclone.resource;


import br.com.tiago.picpayclone.dto.UsuarioDTO;
import br.com.tiago.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO>   {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/{login}/saldo")
    public ResponseEntity<UsuarioDTO> consultarSaldo(@PageableDefault(page = 0, size = 20) Pageable paginacao,
                                                     @PathVariable String login) {
        UsuarioDTO usuarioDTO = usuarioService.consultar(login);
        return responderSucessoComItem(usuarioDTO);
    }

    @GetMapping("/contatos")
    public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
        List<UsuarioDTO> usuarios = usuarioService.listar(login);
        return responderListaDeItens(usuarios);
    }

    @GetMapping("/{login}")
    public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
        UsuarioDTO usuario = usuarioService.consultar(login);
        return responderSucessoComItem(usuario);
    }
}
