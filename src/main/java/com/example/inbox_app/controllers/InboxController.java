package com.example.inbox_app.controllers;

import com.example.inbox_app.folders.Folder;
import com.example.inbox_app.folders.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Spring Boot Controller class to redirect a logged-in used to the inbox page
 * where the user can see all the messages in the inbox folder.
 */
@Controller
public class InboxController {

    @Autowired
    private FolderRepository folderRepository;

    @GetMapping(value = "/")
    public String getHomePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal == null) {
            return "index";
        } else {
            System.out.println("Principal: " + principal);
            System.out.println("Principal name: " + principal.getName());
            System.out.println("Principal attribute name: " + principal.getAttribute("login"));

            // retrieve all folders for the logged-in user
            final String principalLogin = principal.getAttribute("login");
            final List<Folder> userFolders = folderRepository.findAllByUserId(principalLogin);

            // add the folder info to the model. This model can be queried from the inbox-page.html to get all the
            // folder info
            model.addAttribute("userFolders", userFolders);
            return "inbox-page";
        }
    }
}
