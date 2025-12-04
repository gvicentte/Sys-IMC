package org.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "perfil_acesso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "colaborador")
public class PerfilAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da entidade. Chave primária. [cite: 28]

    @Column(unique = true, nullable = false)
    private String login; // Nome de usuário (único). [cite: 28]

    @Column(nullable = false)
    private String senha; // Senha do usuário. [cite: 29]

    @Column(nullable = false)
    private String nivelAcesso; // Nível de permissão (ex: "ADMINISTRADOR", "DEV", "TESTER"). [cite: 30]

    // Relacionamento 1:1 com Colaborador
    // Lado não-proprietário (mappedBy). Mapeado pelo campo 'perfilAcesso' em Colaborador.
    @OneToOne(mappedBy = "perfilAcesso", fetch = FetchType.LAZY)
    private Colaborador colaborador; // Relacionamento 1:1 com Colaborador.
}