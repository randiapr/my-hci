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
public class ModuleApp extends BaseDomain {

    private String name;
    private String description;
    @OneToMany(mappedBy = "moduleApp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserModules> userModules = new ArrayList<>();

    public ModuleApp() {
    }

    public ModuleApp(String name, String description) {
        this.name = name;
        this.description = description;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the userModules
     */
    public List<UserModules> getUserModules() {
        return userModules;
    }

    /**
     * @param userModules the userModules to set
     */
    public void setUserModules(List<UserModules> userModules) {
        this.userModules = userModules;
    }

}
