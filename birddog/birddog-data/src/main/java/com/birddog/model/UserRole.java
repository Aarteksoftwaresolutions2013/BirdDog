package com.birddog.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aartek
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    private Integer userRoleId;
    private String role;
   /* private Set<Comment> comments = new HashSet<Comment>();
    private Set<Login> logins = new HashSet<Login>();

    public UserRole(Set<Comment> comments, Set<Login> logins) {
        this.comments = comments;
        this.logins = logins;
    }*/

    public UserRole() {

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ROLE_ID", unique = true, nullable = false)
    public Integer getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }*/

    @Column(name = "ROLE", length = 20)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRole")
    public Set<Login> getLogins() {
        return this.logins;
    }

    public void setLogins(Set<Login> logins) {
        this.logins = logins;
    }*/

}
