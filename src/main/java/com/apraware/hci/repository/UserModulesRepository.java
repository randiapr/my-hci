package com.apraware.hci.repository;

import com.apraware.hci.domain.UserApp;
import com.apraware.hci.domain.UserModules;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author randi
 */
public interface UserModulesRepository extends JpaRepository<UserModules, Long> {

    List<UserModules> findByUserAppOrderByModuleOrderAsc(UserApp userApp);

    UserModules findByUserAppAndModuleOrder(UserApp userApp, Integer order);

//    UserModules findByUserAppAndModuleApp(UserApp userApp, ModuleApp moduleApp);
}
