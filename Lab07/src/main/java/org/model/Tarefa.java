package org.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"projeto", "responsavel"})
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da entidade. Chave primária. [cite: 43]

    @Column(nullable = false)
    private String titulo; // Nome ou resumo da tarefa. [cite: 44]

    private String descricao; // Detalhes da tarefa a ser executada. [cite: 45]
    private LocalDateTime dataCriacao; // Data e hora em que a tarefa foi registrada. [cite: 46]
    private LocalDate dataLimite; // Data de prazo para a conclusão da tarefa. [cite: 47]
    private String status; // Estado atual da tarefa. [cite: 48]

    // Relacionamento N:1 com Projeto
    // O lado proprietário é a Tarefa, que possui a Chave Estrangeira para Projeto. [cite: 49]
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto; // O projeto ao qual esta tarefa pertence. [cite: 49]

    // Relacionamento N:1 com Colaborador
    // O lado proprietário é a Tarefa, que possui a Chave Estrangeira para Colaborador. [cite: 50]
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Colaborador responsavel; // O colaborador designado para executar a tarefa. [cite: 50]
}