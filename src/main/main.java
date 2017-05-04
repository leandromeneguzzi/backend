/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.bean.Cliente;
import model.dao.ClienteDAO;

/**
 *
 * @author Leandro
 */
public class main {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Cliente> clientesCalculo = new ArrayList<>();
        ClienteDAO cd = new ClienteDAO();
        double mediaFinal = 0.0;

        //lê do teclado 'N'
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite N: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            cd.create(new Cliente(i, "Cliente" + i, "", true, (Math.random() * 2000)));
        }

        clientes = cd.read();
        for (Cliente cliente : clientes) {
            if (cliente.getId() >= 1500 && cliente.getId() <= 2700 && cliente.getSaldo() > 560) {
                mediaFinal += cliente.getSaldo();
                clientesCalculo.add(cliente);
            }
        }
        //Ordena lista
        Collections.sort(clientesCalculo, new ComparadorDeCliente());
        for (Cliente cliente : clientesCalculo) {
            System.out.println(cliente.getNome());
        }
        System.out.println("\nMédia final: " + mediaFinal);

    }
}
