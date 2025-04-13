package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Coleta dos dados do proprietário
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do proprietário:", "Cadastro do Proprietário", JOptionPane.QUESTION_MESSAGE);
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do proprietário:", "Cadastro do Proprietário", JOptionPane.QUESTION_MESSAGE);
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
            return;
        }

        Propietario propietario = new Propietario(nome, cpf);

        // Cadastro dos veículos
        boolean continuar = true;
        while (continuar) {
            String titulo = "Cadastro do Veículo " + propietario.qtdVeiculo();

            String placa = JOptionPane.showInputDialog(null, "Digite a placa do veículo:", titulo, JOptionPane.QUESTION_MESSAGE);
            if (placa == null || placa.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cadastro cancelado ou inválido.");
                break;
            }

            String valorStr = JOptionPane.showInputDialog(null, "Digite o valor do veículo:", titulo, JOptionPane.QUESTION_MESSAGE);
            if (valorStr == null || valorStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cadastro cancelado ou inválido.");
                break;
            }

            float valor;
            try {
                valor = Float.parseFloat(valorStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número válido.");
                continue;
            }

            Veiculo veiculo = new Veiculo(placa, valor);
            propietario.addVeiculo(veiculo);
            if (propietario.qtdVeiculo() >= 5) {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Já foram cadastrados 5 veículos.\nDeseja cadastrar mais?",
                        "Limite Atingido", JOptionPane.YES_NO_OPTION);

                if (resposta != JOptionPane.YES_OPTION) {
                    continuar = false;
                }
            } else {
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Deseja cadastrar outro veículo?",
                        "Continuar?", JOptionPane.YES_NO_OPTION);

                if (resposta != JOptionPane.YES_OPTION) {
                    continuar = false;
                }
            }
        }

        // Exibe o resumo dos dados
        if (propietario.qtdVeiculo() > 0) {
            JOptionPane.showMessageDialog(null,
                    "Cadastro finalizado!\n" +
                            "Proprietário: " + propietario.getNome() + "\n" +
                            "CPF: " + propietario.getCpf() + "\n" +
                            "Veículos cadastrados: " + propietario.qtdVeiculo() + "\n" +
                            "Valor total dos bens: R$ " + String.format("%.2f", propietario.valorBens()));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum veículo foi cadastrado.");
        }
    }
}
