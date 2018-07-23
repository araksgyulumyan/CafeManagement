package com.cafe.manager.api.controller.manager;

import com.cafe.manager.api.facade.manager.ManagerFacade;
import com.cafe.manager.api.facade.table.CafeTableFacade;
import com.cafe.manager.api.model.dashboard.DashboardModel;
import com.cafe.manager.api.model.request.table.CafeTableCreationRequestModel;
import com.cafe.manager.api.model.request.user.UserCreationRequestModel;
import com.cafe.manager.api.model.request.user.UserUpdateRequestModel;
import com.cafe.manager.api.model.response.table.CafeTableResponseModel;
import com.cafe.manager.api.model.response.user.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 4:07 PM
 */

@Controller
@RolesAllowed("ROLE_MANAGER")
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    private ManagerFacade managerFacade;

    @Autowired
    private CafeTableFacade cafeTableFacade;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        final List<UserResponseModel> waiterModels = managerFacade.getWaiters();
        final UserResponseModel managerModel = managerFacade.getManager();
        final List<CafeTableResponseModel> cafeTableResponseModels = cafeTableFacade.getTables();
        final DashboardModel dashboardModel =
                new DashboardModel(new HashSet<>(waiterModels), managerModel, new HashSet<>(cafeTableResponseModels));
        final ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("dashboardModel", dashboardModel);
        return modelAndView;
    }

    @GetMapping("/create_user")
    public ModelAndView getAddUserView() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("userCreationRequestModel", new UserCreationRequestModel());
        return modelAndView;
    }

    @PostMapping(value = "/create_user",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView createUser(@Valid final UserCreationRequestModel userCreationRequestModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create");
        }
        managerFacade.create(userCreationRequestModel);
        return new ModelAndView("redirect:/manager/dashboard");
    }

    @GetMapping("/update_user/{id}")
    public ModelAndView getUpdateUserView(@PathVariable("id") final Long userId) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("userUpdateRequestModel", managerFacade.getById(userId));
        return modelAndView;
    }

    @PostMapping(value = "/update_user/{id}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView updateUser(@PathVariable("id") final Long userId, final @Valid UserUpdateRequestModel requestModel,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/manager/update_user/" + userId);
        }
        managerFacade.update(userId, requestModel);
        return new ModelAndView("redirect:/manager/dashboard");
    }

    @GetMapping(value = "/delete_user/{id}")
    public ModelAndView deleteUser(@PathVariable("id") final Long userId) {
        managerFacade.remove(userId);
        return new ModelAndView("redirect:/manager/dashboard");
    }

    @GetMapping(value = "/create_table")
    public ModelAndView getCreateTableView() {
        ModelAndView modelAndView = new ModelAndView("createTable");
        modelAndView.addObject("cafeTableCreationRequestModel", new CafeTableCreationRequestModel());
        return modelAndView;
    }

    @PostMapping(value = "/create_table",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView createTable(@Valid final CafeTableCreationRequestModel cafeTableCreationRequestModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("createTable");
        }
        cafeTableFacade.create(cafeTableCreationRequestModel);
        return new ModelAndView("redirect:/manager/dashboard");
    }

}
