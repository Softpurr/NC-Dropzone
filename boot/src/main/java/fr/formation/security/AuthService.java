// package fr.formation.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import fr.formation.dao.IUtilisateurDaoJpaRepository;
// import fr.formation.model.Utilisateur;

// @Service
// public class AuthService implements UserDetailsService {
// 	@Autowired
// 	private IUtilisateurDaoJpaRepository daoUtilisateur;

// 	//Cette méthode va être appelée par SPRING SECURITY au moment de la connexion, avec le user saisi en formulaire
// 	@Override
// 	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// 		Utilisateur utilisateur = daoUtilisateur.findByUsername(username);

// 		if (utilisateur == null) { //On a pas trouvé l'utilisateur
// 			//Cette exception va être gérée par SPRING SECURITY (pour afficher un formulaire en erreur)
// 			throw new UsernameNotFoundException("L'utilisateur n'existe pas.");
// 		}

// 		//On retourne le UserDetails qui va être manipulé par SPRING SECURITY
// 		return new UtilisateurPrincipal(utilisateur);
// 	}
// }