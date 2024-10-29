package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoPorCategoria implements EstrategiaRecomendacao {
    private String categoriaDesejada;

    public RecomendacaoPorCategoria(String categoriaDesejada) {
        this.categoriaDesejada = categoriaDesejada;
    }

    @Override
    public List<Produto> recomendar(List<Produto> produtos) {
        List<Produto> recomendados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoriaDesejada)) {
                recomendados.add(produto);
            }
        }
        return recomendados;
    }
}
