package com.kg.registration.controller;

import java.util.List;

import com.kg.registration.model.Register;
import com.kg.registration.repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    // @PostMapping(value="/",headers="Accept=application/json")
    // public ResponseEntity<Void> createUser(@RequestBody Register register, UriComponentsBuilder ucBuilder){
    //     System.out.println("Creating user "+register.getUsername());
    //     registerRepository.save(register);
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(register.getUserid()).toUri());
    //     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    // }

    @RequestMapping(method=RequestMethod.POST)
	public Register create(@RequestBody Register register)
	{
    	register.setUserid(null);
		return registerRepository.saveAndFlush(register);
	}

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Register>> all() {
        System.out.println("GET ALL CALLED");
        return new ResponseEntity<>(registerRepository.findAll(), HttpStatus.OK);
    }
    // @RequestMapping(value = "{email}", method = RequestMethod.PUT)
    // public Register update(@PathVariable Long email, @RequestBody Register updatedRegister) {
    //     Register register = registerRepository.getOne(email);
    //     register.setEmail(updatedRegister.getEmail());
    //     return registerRepository.saveAndFlush(register);
    // }

    // @RequestMapping(method = RequestMethod.GET)
    // public List<Register> read() {
    //   return registerRepository.findAll();
    //   }

    // @RequestMapping(value = "{email}", method = RequestMethod.DELETE)
    // void delete(@PathVariable("email") Long email) {
    //     registerRepository.deleteById(email);
    // }

}