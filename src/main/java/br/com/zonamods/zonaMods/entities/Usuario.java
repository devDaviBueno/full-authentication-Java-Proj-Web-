package br.com.zonamods.zonaMods.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users_db")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres!")
    @NotBlank(message = "O nome é obrigatorio")
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Email(message = "Insira um email valido!")
    @NotBlank(message = "O email é obrigatorio!")
    @Column(name = "email", length = 200, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatorio!")
    @Column(name = "password",columnDefinition = "TEXT", nullable = false)
    private String password;

    @NotBlank(message = "O discord é obrigatorio!")
    @Column(name = "discord", length = 200, nullable = false)
    private String discord;

    @Column(name = "pending", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean pending;

    @NotBlank(message = "A patente é obrigatoria!")
    @Column(name = "patent", length = 240, nullable = false)
    private String patent;

    @NotBlank(message = "O departamento é obrigatorio!")
    @Column(name = "department", length = 240, nullable = false)
    private String department;

    @NotBlank(message = "O ID é orbrigatorio!")
    @Column(name = "Id_player", nullable = false)
    private String idPlayer;

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiscord(String discord) {
        this.discord = discord;
    }

    public String getPatent() {
        return patent;
    }

    public String getDepartment() {
        return department;
    }

    public Boolean getPending() {
        return pending;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDiscord() {
        return discord;
    }

    public Integer getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

}
