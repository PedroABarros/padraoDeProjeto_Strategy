package org.example;

public class Produto {
        private String nome;
        private String categoria;
        private float preco;
        private int popularidade; // Ex: número de vendas ou avaliações

        public Produto(String nome, String categoria, float preco, int popularidade) {
            this.nome = nome;
            this.categoria = categoria;
            this.preco = preco;
            this.popularidade = popularidade;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public float getPreco() {
            return preco;
        }

        public int getPopularidade() {
            return popularidade;
        }
}
