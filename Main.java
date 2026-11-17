/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sajoco
 */
package atvmvp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;



public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame janela = new JFrame("APP Vendas");
        
        janela.setSize(350, 180);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());

         
        JLabel texto = new JLabel("Digite o valor da venda:");

        
        JTextField campoValor = new JTextField(15);

        
        JButton botao = new JButton("Calcular venda");

        
        janela.add(texto);
        janela.add(campoValor);
        janela.add(botao);

        botao.addActionListener(e -> {

            try {

                
                String entrada = campoValor.getText()
                        .trim().replace(",", ".");

                double valorProduto = Double.parseDouble(entrada);

                
                if (valorProduto <= 0) {
                    JOptionPane.showMessageDialog(
                            janela,
                            "Digite um valor maior que zero!"
                    );
                    return;
                }

                double percentualDesconto = 0;
                double valorFinal = valorProduto;

                
                if (valorProduto > 500) {

                    String desconto = JOptionPane.showInputDialog(
                            janela,
                            "Venda acima de R$ 500,00!\n"
                            + "Informe o percentual de desconto (somente números):"
                    );

                    
                    if (desconto == null) {
                        return;
                    }

                    
                    if (!desconto.matches("\\d+")) {
                        JOptionPane.showMessageDialog(
                                janela,
                                "Informe somente números inteiros!"
                        );
                        return;
                    }

                    percentualDesconto = Double.parseDouble(desconto);

                    
                    if (percentualDesconto < 0
                            || percentualDesconto > 100) {

                        JOptionPane.showMessageDialog(
                                janela,
                                "O desconto deve estar entre 0 e 100%!"
                        );
                        return;
                    }

                    
                    valorFinal = valorProduto
                            - (valorProduto * percentualDesconto / 100);
                }

                
                JOptionPane.showMessageDialog(
                        janela,
                        String.format(
                                "Valor da venda: R$ %.2f\n"
                                + "Desconto: %.0f%%\n"
                                + "Valor final: R$ %.2f",
                                valorProduto,
                                percentualDesconto,
                                valorFinal
                        ),
                        "Resultado da venda",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Digite um valor válido para a venda!"
                );

            }

        });

        
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
     
    
    
    
    //Mensagem final
       // JOptionPane.showMessageDialog(null, mensagem);
    }

}
    
    

