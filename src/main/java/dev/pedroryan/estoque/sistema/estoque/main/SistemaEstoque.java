/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.pedroryan.estoque.sistema.estoque.main;

import dev.pedroryan.estoque.sistema.estoque.MenuPrincipal;
import dev.pedroryan.estoque.sistema.estoque.service.ProdutoService;
import java.sql.SQLException;


/**
 *
 * @author preya
 */
public class SistemaEstoque {
    public static void main(String[] args) throws SQLException {
        ProdutoService service = new ProdutoService();
        MenuPrincipal menu = new MenuPrincipal(service);
        menu.exibirMenu();
    }
}
