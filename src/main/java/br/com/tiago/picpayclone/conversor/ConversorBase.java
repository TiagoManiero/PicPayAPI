package br.com.tiago.picpayclone.conversor;

import br.com.tiago.picpayclone.dto.TransacaoDTO;
import br.com.tiago.picpayclone.model.Transacao;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public abstract class ConversorBase<E, D> {
    public abstract D converterEntidadeParaDto(E entidade);

    public abstract E converterDtoParaEntidade(D dto);

    public List<D> converterEntidadesParaDtos(List<E> entidades) {
        List<D> dtos = new ArrayList<>();
        entidades.stream().forEach(entidade -> dtos.add(converterEntidadeParaDto(entidade)));
        return dtos;
    }

    public List<E> converterDtosParaEntidades(List<D> dtos) {
        List<E> entidades = new ArrayList<>();
        dtos.stream().forEach(dto -> entidades.add(converterDtoParaEntidade(dto)));
        return entidades;
    }
}
