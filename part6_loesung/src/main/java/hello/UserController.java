package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping(path="/dos")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @PostMapping(path="/add")
//    public @ResponseBody
//    String addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
//
//        User user = new User(firstName, lastName);
//        userRepository.save(user);
//        return "Saved";
//    }

    @PostMapping(path= "/add/{id}")
    public ResponseEntity<Resource<User>> addUser (@PathVariable("id") Optional<User> user) {

        return user.map(u -> userRepository.save(u))
                .map(Resource<User>::new)
                .map(u -> new ResponseEntity<>(u, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
