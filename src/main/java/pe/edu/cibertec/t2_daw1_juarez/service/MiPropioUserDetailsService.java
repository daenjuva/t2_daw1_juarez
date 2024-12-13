package pe.edu.cibertec.t2_daw1_juarez.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.t2_daw1_juarez.entities.User;
import pe.edu.cibertec.t2_daw1_juarez.respository.UserRepository;

import java.util.Optional;

@Service
public class MiPropioUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public MiPropioUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // select * from user where name = username
        Optional<User> userOptional = userRepository.findByName(username); // userRepository.findAll().stream().filter(x -> x.getName().equals(username)).findFirst();
        if(userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Empleado no encontrado");
        }
        return userOptional.get();
    }
}
