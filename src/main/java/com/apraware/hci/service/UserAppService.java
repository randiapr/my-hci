package com.apraware.hci.service;

import com.apraware.hci.domain.UserApp;
import com.apraware.hci.repository.UserAppRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author randi
 */
@Service
public class UserAppService {

    @Autowired
    private final UserAppRepository userAppRepo;

    UserAppService(UserAppRepository repo) {
        this.userAppRepo = repo;
    }

    public UserApp create(UserApp a) {
        return userAppRepo.save(a);
    }

    public UserApp update(UserApp a, Long id) {
        a.setId(id);
        return userAppRepo.save(a);
    }

    public void delete(Long id) {
        userAppRepo.deleteById(id);
    }

//    public Page<UserApp> getAllPageable(Integer pageSize, Integer pageNumber, String sorting) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public List<UserApp> getAll() {
        var list = userAppRepo.findAll();
        return list;
    }

    public Optional<UserApp> findById(Long id) {
        return userAppRepo.findById(id);
    }

}
