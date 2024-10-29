package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoPorPreco implements EstrategiaRecomendacao {
    @Override
    public List<Produto> recomendar(List<Produto> produtos) {
        produtos.sort((p1, p2) -> Float.compare(p1.getPreco(), p2.getPreco()));
        return produtos.subList(0, Math.min(5, produtos.size())); // Recomenda os 5 mais baratos
    }
}
