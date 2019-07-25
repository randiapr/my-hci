package com.apraware.hci.web;

import com.apraware.hci.domain.ModuleApp;
import com.apraware.hci.request.ModuleAppRequest;
import com.apraware.hci.service.ModuleService;
import com.apraware.hci.service.RequestValidationService;
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
@RequestMapping("/api/v1/module")
@Api(value = "Module App", tags = "Module App")
public class ModuleAppController {

    @Autowired
    private ModuleService service;
    @Autowired
    private RequestValidationService reqService;

    @ApiOperation(value = "Add new Module App", response = ModuleApp.class)
    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody ModuleAppRequest module, BindingResult result) {
        var errorReq = reqService.ValidationService(result);
        if (errorReq != null) {
            return errorReq;
        }
        var newModule = new ModuleApp();
        try {
            BeanUtils.copyProperties(newModule, module);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(UserAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        var moduleApp = service.create(newModule);
        return new ResponseEntity<>(moduleApp, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update Module App", response = ModuleApp.class)
    @PutMapping
    ResponseEntity<?> update(
            @ApiParam(value = "Module App ID", required = true)
            @PathVariable(value = "id") Long id, @Valid @RequestBody ModuleAppRequest module) {
        var updateModule = new ModuleApp();
        try {
            BeanUtils.copyProperties(updateModule, module);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(UserAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ResponseEntity.ok(service.update(updateModule, id));
    }

    @ApiOperation(value = "Get All Module App", response = ModuleApp.class, responseContainer = "List")
    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @ApiOperation(value = "Delete Module App by Module Id")
    @DeleteMapping
    ResponseEntity<?> delete(
            @ApiParam(value = "Module App ID", required = true)
            @PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Succeed");
    }

}
