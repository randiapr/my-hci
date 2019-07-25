package com.apraware.hci.web;

import com.apraware.hci.domain.ModuleApp;
import com.apraware.hci.domain.UserApp;
import com.apraware.hci.domain.UserModules;
import com.apraware.hci.request.UserModulesReq;
import com.apraware.hci.response.UserModuleResponse;
import com.apraware.hci.service.RequestValidationService;
import com.apraware.hci.service.UserModulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
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
@RequestMapping("/api/v1/userModules")
@Api(value = "User Modules App", tags = "User Modules App")
public class UserModulesController {

    @Autowired
    private UserModulesService service;
    @Autowired
    private RequestValidationService reqService;

    @ApiOperation(value = "Add new User Module App", response = UserModules.class)
    @PostMapping
    ResponseEntity<?> create(@RequestBody UserModulesReq userModuleReq, BindingResult result) {
        var errorReq = reqService.ValidationService(result);
        if (errorReq != null) {
            return errorReq;
        }
        return new ResponseEntity<>(service.create(userModuleReq), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update User Module App", response = UserModules.class)
    @PutMapping("{id}")
    ResponseEntity<?> update(
            @ApiParam(value = "User Module App ID", required = true)
            @PathVariable(value = "id") Long id, @Valid @RequestBody UserModulesReq req) {
        var moduleApp = new ModuleApp();
        moduleApp.setId(req.getModuleId());
        var userApp = new UserApp();
        userApp.setId(req.getUserId());
        var userModules = new UserModules();
        userModules.setId(id);
        userModules.setModuleApp(moduleApp);
        userModules.setUserApp(userApp);
        return ResponseEntity.ok(service.update(userModules));
    }

    @ApiOperation(value = "Get All User Module App", response = UserModules.class, responseContainer = "List")
    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @ApiOperation(value = "Get User Module App by User ID", response = UserModuleResponse.class, responseContainer = "List")
    @GetMapping("{id}")
    ResponseEntity<?> getByUserId(
            @ApiParam(value = "User Module App ID", required = true)
            @PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(service.findByUserId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Module App by Module Id")
    @DeleteMapping
    ResponseEntity<?> delete(
            @ApiParam(value = "User Module App ID", required = true)
            @PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Succeed");
    }
}
