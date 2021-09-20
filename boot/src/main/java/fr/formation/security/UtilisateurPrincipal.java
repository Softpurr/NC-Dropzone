// package fr.formation.security;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import fr.formation.model.Utilisateur;

// public class UtilisateurPrincipal implements UserDetails {
// 	private Utilisateur utilisateur; //Cet attribut est là pour l'encapsulation

// 	//On attend l'utilisateur qui veut se connecter ...
// 	public UtilisateurPrincipal(Utilisateur utilisateur) {
// 		this.utilisateur = utilisateur;
// 	}

// 	//Liste des autorisations de l'utilisateur (rôles, etc.)
// 	@Override
// 	public Collection<? extends GrantedAuthority> getAuthorities() {
// 		List<GrantedAuthority> authorities = new ArrayList<>();

// 		if (utilisateur.isAdmin()) {
// 			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
// 		}
		
// 		else {
// 			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
// 		}

// 		return authorities;
// 	}

// 	//Mot de passe de l'utilisateur
// 	@Override
// 	public String getPassword() {
// 		return utilisateur.getPassword();
// 	}

// 	//Nom d'utilisateur de l'utilisateur ...
// 	@Override
// 	public String getUsername() {
// 		return utilisateur.getUsername();
// 	}

// 	@Override
// 	public boolean isAccountNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
// 		return true;
// 	}

// 	@Override
// 	public boolean isEnabled() {
// 		return true;
// 	}
// }