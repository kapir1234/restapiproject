package inz.restapiproject.service;


import inz.restapiproject.model.Lights;
import inz.restapiproject.repository.LightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LightsService {

    @Autowired
    LightsRepository lightsRepository;

    //Zwraca wszystkie urzadzenia
    public List<Lights> getUsers(){
        return lightsRepository.findAll();
    }

    public void savelight(Lights n) {
        lightsRepository.save(n);
    }

    public List<Lights> findLights(long idUser) {
        return lightsRepository.getLights(idUser);
    }
}
