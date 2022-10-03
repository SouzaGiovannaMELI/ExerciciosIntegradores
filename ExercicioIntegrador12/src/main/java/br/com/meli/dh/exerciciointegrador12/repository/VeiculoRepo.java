package br.com.meli.dh.exerciciointegrador12.repository;

import br.com.meli.dh.exerciciointegrador12.dto.VeiculoDTO;
import br.com.meli.dh.exerciciointegrador12.exception.NotFoundException;
import br.com.meli.dh.exerciciointegrador12.model.Veiculo;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepo {
    private final String linkFile = "src/main/resources/veiculos.json";
    private ObjectMapper mapper = new ObjectMapper();

    public void saveVeiculo(Veiculo novoVeiculo){
        List<Veiculo> veiculos = new ArrayList<>(getVeiculosArquivo());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        veiculos.add(novoVeiculo);

        try{
            writer.writeValue(new File(linkFile), veiculos);
        } catch (Exception ex){
            System.out.println("Erro ao salvar os dados!");
        }
    }

    public List<VeiculoDTO> getAll(){
        List<VeiculoDTO> veiculosDTO = new ArrayList<>();

        for(Veiculo veiculo : getVeiculosArquivo()){
            veiculosDTO.add(new VeiculoDTO(veiculo));
        }

        return veiculosDTO;
    }

    public Optional<Veiculo> getVeiculo(int id) throws NotFoundException {
        if(getVeiculosArquivo().size() < id)
            throw new NotFoundException("Id não encontrado!");
        return Optional.of(getVeiculosArquivo().get(id - 1));
    }

    private List<Veiculo> getVeiculosArquivo(){
        List<Veiculo> veiculos = null;

        try{
            veiculos = Arrays.asList(mapper.readValue(new File(linkFile), Veiculo[].class));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return veiculos;
    }
}
