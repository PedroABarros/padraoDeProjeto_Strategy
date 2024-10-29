package org.example;

import java.util.List;

public class ServicoRecomendacao {
    private EstrategiaRecomendacao estrategia;

    public void setEstrategia(EstrategiaRecomendacao estrategia) {
        this.estrategia = estrategia;
    }

    public List<Produto> recomendarProdutos(List<Produto> produtos) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia não definida.");
        }
        return estrategia.recomendar(produtos);
    }
}