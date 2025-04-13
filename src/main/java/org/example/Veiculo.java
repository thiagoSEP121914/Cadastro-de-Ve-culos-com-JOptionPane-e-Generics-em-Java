package org.example;

import java.util.Objects;

public class Veiculo {

    private String placa;
    private Float valor;

    public Veiculo() {
    }

    public Veiculo(String placa, Float valor) {
        this.placa = placa;
        this.valor = valor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return "placa: " + placa +", valor: " + String.format("%.3f",valor);
    }

}
