package org.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"perfilAcesso", "projetos", "tarefasDesignadas"})
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da entidade. Chave primária. [cite: 17]

    @Column(nullable = false)
    private String nome; // Nome completo do colaborador. [cite: 18]

    @Column(unique = true, nullable = false)
    private String matricula; // Número de matrícula ou identificação interna única. [cite: 19]

    @Column(unique = true, nullable = false)
    private String email; // Endereço de e-mail profissional. [cite: 19]

    private LocalDate dataContratacao; // Data em que o colaborador foi contratado. [cite: 20]

    // Relacionamento 1:1 com PerfilAcesso
    // O lado proprietário (Owning Side) é quem tem a FK.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 1:1 com PerfilAcesso. [cite: 21]
    @JoinColumn(name = "perfil_acesso_id")
    private PerfilAcesso perfilAcesso;

    // Relacionamento N:N com Projeto
    // Colaborador é o lado proprietário (Owning Side), gerenciando a tabela de junção.
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "projeto_colaborador",
            joinColumns = @JoinColumn(name = "colaborador_id"),
            inverseJoinColumns = @JoinColumn(name = "projeto_id")
    )
    private Set<Projeto> projetos; // Lista dos projetos em que o colaborador está alocado. [cite: 21, 22]

    // Relacionamento 1:N com Tarefa (o lado One do ManyToOne em Tarefa)
    // Mapeado por 'responsavel' em Tarefa.
    @OneToMany(mappedBy = "responsavel", fetch = FetchType.LAZY)
    private Set<Tarefa> tarefasDesignadas; // Lista das tarefas que foram designadas a este colaborador. [cite: 23, 24]
}