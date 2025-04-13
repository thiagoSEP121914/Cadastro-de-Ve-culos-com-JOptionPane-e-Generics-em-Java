package org.example;


import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Propietario {
    private String nome;
    private String cpf;
    private Set<Veiculo> veiculos;

    public Propietario () {
    }
    public Propietario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        veiculos = new HashSet<>();
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Float valorBens() {
        Float valorTotal = 0F;
        for (Veiculo veiculo: veiculos) {
            valorTotal += veiculo.getValor();
        }
        return valorTotal;
    }

    public  int qtdVeiculo () {
        return veiculos.size();
    }

    public Veiculo removeVeiculo(String placa) {
        Optional<Veiculo> veiculoOptional = veiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
         veiculoOptional.ifPresent(veiculos::remove);
        return veiculoOptional.orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }
}
