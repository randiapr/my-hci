package com.apraware.hci.response;

/**
 *
 * @author randi
 */
public class UserModuleResponse {

    private String name;
    private String order;

    public UserModuleResponse() {
    }

    public UserModuleResponse(String name, String order) {
        this.name = name;
        this.order = order;
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
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

}
