package com.apraware.hci.request;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author randi
 */
public class UserModulesReq {

    @NotBlank(message = "User ID Required")
    private Long userId;
    @NotBlank(message = "Module ID Required")
    private Long moduleId;
    @NotBlank(message = "Module Order Required")
    private Integer moduleOrder;

    public UserModulesReq() {
    }

    public UserModulesReq(Long userId, Long moduleId, Integer moduleOrder) {
        this.userId = userId;
        this.moduleId = moduleId;
        this.moduleOrder = moduleOrder;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the moduleId
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * @param moduleId the moduleId to set
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * @return the moduleOrder
     */
    public Integer getModuleOrder() {
        return moduleOrder;
    }

    /**
     * @param moduleOrder the moduleOrder to set
     */
    public void setModuleOrder(Integer moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

}
