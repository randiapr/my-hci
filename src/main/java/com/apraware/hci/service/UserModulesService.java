package com.apraware.hci.service;

import com.apraware.hci.domain.ModuleApp;
import com.apraware.hci.domain.UserApp;
import com.apraware.hci.domain.UserModules;
import com.apraware.hci.repository.UserModulesRepository;
import com.apraware.hci.request.UserModulesReq;
import com.apraware.hci.response.UserModuleResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author randi
 */
@Service
public class UserModulesService {

    @Autowired
    private final UserModulesRepository repo;

    public UserModulesService(UserModulesRepository repo) {
        this.repo = repo;
    }

    public UserModules create(UserModulesReq a) {
        var moduleApp = new ModuleApp();
        moduleApp.setId(a.getModuleId());
        var userApp = new UserApp();
        userApp.setId(a.getUserId());
        var userModules = new UserModules(userApp, moduleApp, a.getModuleOrder());
        var exists = repo.findByUserAppAndModuleOrder(userModules.getUserApp(), userModules.getModuleOrder());
        if (null != exists) {
            swapModuleOrder(exists, a.getModuleOrder());
        }
        return repo.save(userModules);
    }

    public UserModules update(UserModules a) {
        return repo.save(a);
    }

    private void swapModuleOrder(UserModules a, int order) {
        a.setModuleOrder(order);
        repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<UserModuleResponse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<UserModuleResponse> findByUserId(Long id) {
        var userApp = new UserApp();
        userApp.setId(id);
        var listUserModules = repo.findByUserAppOrderByModuleOrderAsc(userApp);
        var resp = new ArrayList<UserModuleResponse>();
        listUserModules.forEach(userMod -> {
            var userMods = new UserModuleResponse();
            userMods.setName(String.valueOf(userMod.getModuleApp().getName()));
            userMods.setOrder(String.valueOf(userMod.getModuleOrder()));
            resp.add(userMods);
        });
        return resp;
    }

}
