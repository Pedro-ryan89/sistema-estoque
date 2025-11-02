/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.pedroryan.estoque.sistema.estoque.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dev.pedroryan.estoque.sistema.estoque.model.Produto;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author preya
 */
public class GsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE_PATH = Path.of("data","produtos.json");

    // Exporta lista de produtos para arquivo JSON
    public static void exportarProdutos(List<Produto> produtos) throws IOException {
        // vai Garantir que a pasta "data" exista
        Files.createDirectories(FILE_PATH.getParent());

        try (Writer writer = new FileWriter(FILE_PATH.toFile())) {
            gson.toJson(produtos, writer);
        }
    }

    // Importa lista de produtos de um arquivo JSON
    public static List<Produto> importarProdutos() throws IOException {
        // Se o arquivo não existir, retorna lista vazia
        if (!Files.exists(FILE_PATH)) {
            Files.createDirectories(FILE_PATH.getParent());
            Files.createFile(FILE_PATH);
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(FILE_PATH.toFile())) {
            Type listType = new TypeToken<List<Produto>>() {}.getType();
            List<Produto> produtos = gson.fromJson(reader, listType);
            return produtos != null ? produtos : new ArrayList<>();
        }
    }
}
