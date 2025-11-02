/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.pedroryan.estoque.sistema.estoque.dao.ProdutoDAO;
import dev.pedroryan.estoque.sistema.estoque.model.Produto;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author preya
 */
public class ProdutoService {
     private final ProdutoDAO dao;

    public ProdutoService() throws SQLException {
        this.dao = new ProdutoDAO();
    }

    public void adicionarProduto(Produto produto) throws SQLException {
        dao.salvar(produto);
    }

    public void atualizarProduto(Produto produto) throws SQLException {
        dao.atualizar(produto);
    }

    public void removerProduto(int id) throws SQLException {
        dao.deletar(id);
    }

    public List<Produto> listarProdutos() throws SQLException {
        return dao.listarTodos();
    }

    public Produto buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }

    public List<Produto> buscarPorNome(String nome) throws SQLException {
        return dao.buscarPorNome(nome);
    }

    public double valorTotalEstoque() throws SQLException {
        return dao.calcularValorTotalEstoque();
    }
    
}
