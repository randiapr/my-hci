package com.apraware.hci.service;

import com.apraware.hci.domain.ModuleApp;
import com.apraware.hci.repository.ModuleAppRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author randi
 */
@Service
public class ModuleService {

    @Autowired
    private final ModuleAppRepository repo;

    public ModuleService(ModuleAppRepository repo) {
        this.repo = repo;
    }

    public ModuleApp create(ModuleApp a) {
        return repo.save(a);
    }

    public ModuleApp update(ModuleApp a, Long id) {
        a.setId(id);
        return repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<ModuleApp> getAll() {
        return repo.findAll();
    }

}
