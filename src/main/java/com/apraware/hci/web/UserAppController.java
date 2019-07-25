package com.apraware.hci.web;

import com.apraware.hci.domain.UserApp;
import com.apraware.hci.request.UserRequest;
import com.apraware.hci.service.RequestValidationService;
import com.apraware.hci.service.UserAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author randi
 */
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User App Home Credit Indonesia", tags = "User App")
public class UserAppController {

    @Autowired
    private UserAppService service;
    @Autowired
    private RequestValidationService reqService;

    @ApiOperation(value = "Add new User App", response = UserApp.class)
    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody UserRequest user, BindingResult result) {
        var errorReq = reqService.ValidationService(result);
        if (errorReq != null) {
            return errorReq;
        }
        var newUser = new UserApp();
        try {
            BeanUtils.copyProperties(newUser, user);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(UserAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        var userApp = service.create(newUser);
        return new ResponseEntity<>(userApp, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update User App", response = UserApp.class)
    @PutMapping
    ResponseEntity<?> update(
            @ApiParam(value = "User App ID", required = true)
            @PathVariable(value = "id") Long id, @Valid @RequestBody UserRequest user) {
        var updateUser = new UserApp();
        try {
            BeanUtils.copyProperties(updateUser, user);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(UserAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResponseEntity.ok(service.update(updateUser, id));
    }

    @ApiOperation(value = "Get All User App", response = UserApp.class, responseContainer = "List")
    @GetMapping
    ResponseEntity<?> getAll() {
        var userList = service.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User App by User ID")
    @DeleteMapping("{id}")
    ResponseEntity<?> delete(
            @ApiParam(value = "User ID", required = true)
            @PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Succeed");
    }

}
