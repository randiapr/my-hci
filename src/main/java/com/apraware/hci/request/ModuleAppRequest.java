package com.apraware.hci.request;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author randi
 */
public class ModuleAppRequest {

    @NotBlank(message = "Module Name Required")
    private String name;
    private String description;

    public ModuleAppRequest() {
    }

    public ModuleAppRequest(String name, String description) {
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

}
