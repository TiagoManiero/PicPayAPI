package br.com.tiago.picpayclone.conversor;

import br.com.tiago.picpayclone.dto.UsuarioDTO;
import br.com.tiago.picpayclone.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConversor extends ConversorBase<Usuario, UsuarioDTO> {
    @Override
    public UsuarioDTO converterEntidadeParaDto(Usuario entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Usuario, UsuarioDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entidade, UsuarioDTO.class);
    }

    @Override
    public Usuario converterDtoParaEntidade(UsuarioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UsuarioDTO, Usuario>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(dto, Usuario.class);
    }
}
