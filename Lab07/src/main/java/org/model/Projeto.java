package org.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"colaboradores", "tarefas"})
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da entidade. Chave primária. [cite: 34]

    @Column(nullable = false)
    private String nome; // Nome do projeto. [cite: 34]

    private String descricao; // Breve descrição do objetivo do projeto. [cite: 35]
    private LocalDate dataInicio; // Data de início do projeto. [cite: 36]
    private LocalDate dataFimPrevista; // Data prevista para a conclusão do projeto. [cite: 37]
    private String status; // Estado atual do projeto. [cite: 37]

    // Relacionamento N:N com Colaborador
    // Lado não-proprietário (mappedBy). Mapeado pelo campo 'projetos' em Colaborador.
    @ManyToMany(mappedBy = "projetos", fetch = FetchType.LAZY)
    private Set<Colaborador> colaboradores; // Lista dos colaboradores alocados neste projeto.

    // Relacionamento 1:N com Tarefa
    // Lado proprietário (Owning Side). Mapeado por 'projeto' em Tarefa.
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tarefa> tarefas; // Lista das tarefas que compõem este projeto.
}