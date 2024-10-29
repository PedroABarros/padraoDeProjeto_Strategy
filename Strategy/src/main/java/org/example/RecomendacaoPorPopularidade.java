package org.example;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoPorPopularidade implements EstrategiaRecomendacao {
    @Override
    public List<Produto> recomendar(List<Produto> produtos) {
        produtos.sort((p1, p2) -> Integer.compare(p2.getPopularidade(), p1.getPopularidade()));
        return produtos.subList(0, Math.min(5, produtos.size())); // Recomenda os 5 mais populares
    }
}
