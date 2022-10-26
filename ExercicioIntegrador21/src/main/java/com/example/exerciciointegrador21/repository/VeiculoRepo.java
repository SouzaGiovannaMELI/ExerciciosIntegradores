package com.example.exerciciointegrador21.repository;

import com.example.exerciciointegrador21.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VeiculoRepo extends JpaRepository<Veiculo, Long> {
    @Query("select v.placa from Veiculo v")
    List<String> findAllPlaca();

    @Query("select v.placa, v.marca from Veiculo v where v.fabricacao = :ano")
    List<Object> findAllPlacasAndMarcaGroupByFabricacao(int ano);

    @Query(value = "select placa from veiculo where fabricacao = extract(year from current_date) and rodas > 4", nativeQuery = true)
    List<String> findAllPlacaOnVeiculoQuatroRodasAndFabricadoAnoAtual();

    @Query(value = "select placa, marca, modelo from veiculo inner join sinistro where veiculo.id = sinistro.id_veiculo and (select sum(perda_economica) from sinistro where sinistro.id_veiculo = veiculo.id) > 10000", nativeQuery = true)
    List<Object> findAllPercaMaiorDezMil();

    @Query(value = "select placa, marca, modelo, sum(perda_economica) from veiculo inner join sinistro where veiculo.id = sinistro.id_veiculo and (select sum(perda_economica) from sinistro where sinistro.id_veiculo = veiculo.id) > 10000 group by veiculo.id", nativeQuery = true)
    List<Object> findAllPercaMaiorDezMilViewPerdaTotal();
}
