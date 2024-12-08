package fr.insa.soa.authenticationService.service;



import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.soa.authenticationService.model.User;
import fr.insa.soa.authenticationService.repository.UserRepository;


@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    // Récupérer l'utilisateur connecté
    // Variable pour stocker l'utilisateur connecté en mémoire
    @Getter
    private User connectedUser;

    // Vérification des informations d'identification de l'utilisateur
    public boolean login(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        System.out.println("user trouvé"); // Recherche de l'utilisateur par nom d'utilisateur
        if (user != null && user.getPassword().equals(password)) {
            connectedUser = user;  // Stocke l'utilisateur connecté
            return true;
        }
        return false;
    }

    // Déconnexion (réinitialise l'utilisateur connecté)
    public void logout() {
        connectedUser = null;
    }
}