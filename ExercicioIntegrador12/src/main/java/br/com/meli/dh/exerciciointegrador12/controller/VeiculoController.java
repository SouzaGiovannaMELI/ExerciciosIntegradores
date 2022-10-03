package br.com.meli.dh.exerciciointegrador12.controller;

import br.com.meli.dh.exerciciointegrador12.dto.VeiculoDTO;
import br.com.meli.dh.exerciciointegrador12.model.Veiculo;
import br.com.meli.dh.exerciciointegrador12.service.IVeiculo;
import br.com.meli.dh.exerciciointegrador12.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {
    private IVeiculo veiculoService = new VeiculoService();

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> getAllVeiculos(){
        List<VeiculoDTO> veiculos = veiculoService.getAllVeiculos();

        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addVeiculo(@RequestBody Veiculo veiculo){
        veiculoService.saveVeiculo(veiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable int id){
        return new ResponseEntity<>(veiculoService.getVeiculo(id), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VeiculoDTO>> getVeiculosByDateManufacturing(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(veiculoService.getVeiculosByDateManufacturing(LocalDate.parse(since), LocalDate.parse(to)), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<VeiculoDTO>> getVeiculosByPrice(@RequestParam double since, @RequestParam double to){
        return new ResponseEntity<>(veiculoService.getVeiculosByPrice(since, to), HttpStatus.OK);
    }
}
