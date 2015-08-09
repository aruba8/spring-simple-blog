package com.blog.controller;

import com.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
//    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView adduser(ModelMap model) {
        return new ModelAndView("adduser", "command", new User());
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String updateuser(@ModelAttribute("userform") User user, ModelMap model) {
//        logger.debug(user.toString());
//        this.userService.saveUser(user);
        return "articles";
    }
}
