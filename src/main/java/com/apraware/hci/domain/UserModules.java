package com.apraware.hci.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author randi
 */
@Entity
public class UserModules extends BaseDomain {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserApp userApp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private ModuleApp moduleApp;
    private int moduleOrder;

    /**
     * @return the moduleOrder
     */
    public int getModuleOrder() {
        return moduleOrder;
    }

    /**
     * @param moduleOrder the moduleOrder to set
     */
    public void setModuleOrder(int moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

    public UserModules() {
    }

    public UserModules(UserApp userApp, ModuleApp moduleApp, int moduleOrder) {
        this.userApp = userApp;
        this.moduleApp = moduleApp;
        this.moduleOrder = moduleOrder;
    }

    /**
     * @return the userApp
     */
    public UserApp getUserApp() {
        return userApp;
    }

    /**
     * @param userApp the userApp to set
     */
    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    /**
     * @return the moduleApp
     */
    public ModuleApp getModuleApp() {
        return moduleApp;
    }

    /**
     * @param moduleApp the moduleApp to set
     */
    public void setModuleApp(ModuleApp moduleApp) {
        this.moduleApp = moduleApp;
    }

}
