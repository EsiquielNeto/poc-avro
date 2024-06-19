package br.com.studies.controller;


import br.com.studies.common.domain.PersonModel;
import br.com.studies.common.domain.service.PersonService;
import br.com.studies.controller.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<br.com.studies.common.domain.PersonModel> listPeople() {
        return personService.list();
    }

    @GetMapping("/{personId}")
    public PersonModel getPersonById(@PathVariable("personId") String personId) {
        return personService.findById(personId);
    }

    @PostMapping
    public PersonModel create(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @DeleteMapping("/{personId}")
    public void remove(@PathVariable("personId") String personId) {
        personService.remove(personId);
    }
}
