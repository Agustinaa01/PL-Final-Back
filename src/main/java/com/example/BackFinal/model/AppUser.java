package com.example.BackFinal.model;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "usr")
public class AppUser
        {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Integer id;
    private String password;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private AppUserRole appRole;
    public AppUser() {
    }

    @OneToMany() //relacion usuario/pedido
        private List<Pedido> pedidos;

    //public AppUser(Integer id, String password, String name, String email, AppUserRole appRole, List<Pedido> pedidos) {
      //  this.id = id;
        //this.password = password;
        //this.name = name;
        //this.email = email;
        //this.appRole = appRole;
        //this.pedidos = pedidos;
    //}
    public AppUser(String password, String name, String email, AppUserRole appRole, List<Pedido> pedidos) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.appRole = appRole;
        this.pedidos = pedidos;
    }


            public String getPassword() {
        return password;
    }





            public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUserRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppUserRole appRole) {
        this.appRole = appRole;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", appUserRole=" +  appRole+
                '}';
    }
}
