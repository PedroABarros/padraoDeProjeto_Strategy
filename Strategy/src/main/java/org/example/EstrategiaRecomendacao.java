package org.example;

import java.util.List;

public interface EstrategiaRecomendacao {
    List<Produto> recomendar(List<Produto> produtos);
}