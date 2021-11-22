import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Java");
        curso2.setDescricao("Descrição curso java");
        curso2.setCargaHoraria(8);



        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setDate(LocalDate.now());

//        System.out.println(curso1 + ("\n"));
//        System.out.println(curso2 + ("\n"));
//        System.out.println(mentoria);


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java");
        bootcamp.setDescricao("Descrição do Bootcamp Java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devfernando = new Dev();
        devfernando.setNome("Fernando");
        devfernando.inscreverBootcamp(bootcamp);
        System.out.println("Conteudo Inscritos Fernando: " + devfernando.getConteudiInscrito());
        devfernando.progredir();
        System.out.println("_");
        System.out.println("Conteudo Inscritos Fernando: " + devfernando.getConteudiInscrito());
        System.out.println("Conteudo concluidos Fernando: " + devfernando.getConteudoConcluidos());
        System.out.println("XP: " + devfernando.calcularTotalXp());


        System.out.println("____________________");

        Dev devSabrina = new Dev();
        devSabrina.setNome("Sabrina");
        devSabrina.inscreverBootcamp(bootcamp);
        System.out.println("Conteudo Inscritos Sabrina: " + devSabrina.getConteudiInscrito());
        devSabrina.progredir();
        devSabrina.progredir();
        devSabrina.progredir();
        System.out.println("_");
        System.out.println("Conteudo Inscritos Sabrina: " + devSabrina.getConteudiInscrito());
        System.out.println("Conteudo concluidos Sabrina" + devSabrina.getConteudoConcluidos());
        System.out.println("XP: " + devfernando.calcularTotalXp());


    }
}
