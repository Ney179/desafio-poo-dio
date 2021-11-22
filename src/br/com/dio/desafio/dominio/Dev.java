package br.com.dio.desafio.dominio;

import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudiInscrito = new LinkedHashSet<Conteudo>();
    private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<Conteudo>();

    public void inscreverBootcamp(Bootcamp bootecamp){
        this.conteudiInscrito.addAll(bootecamp.getConteudos());
        bootecamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudiInscrito.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudoConcluidos.add(conteudo.get());
            this.conteudiInscrito.remove(conteudo.get());
        }else{
            System.err.println("Você não esta matriculados em nenhum conteudo!");
        }
    }

    public double calcularTotalXp(){
        return this.conteudoConcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularxp())
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudiInscrito() {
        return conteudiInscrito;
    }

    public Set<Conteudo> getConteudoConcluidos() {
        return conteudoConcluidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteudiInscrito(Set<Conteudo> conteudiInscrito) {
        this.conteudiInscrito = conteudiInscrito;
    }

    public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
        this.conteudoConcluidos = conteudoConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudiInscrito, dev.conteudiInscrito) && Objects.equals(conteudoConcluidos, dev.conteudoConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudiInscrito, conteudoConcluidos);
    }
}
