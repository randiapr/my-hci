package com.apraware.hci.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author randi
 */
@Entity
@JsonIgnoreProperties(value = {"userModules"})
public class UserApp extends BaseDomain {

    private String name;
    private String email;
    @OneToMany(mappedBy = "userApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserModules> userModules = new ArrayList<>();

    public UserApp() {
    }

    public UserApp(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
