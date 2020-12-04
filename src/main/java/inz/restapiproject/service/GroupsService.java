package inz.restapiproject.service;

import inz.restapiproject.model.Groups;
import inz.restapiproject.model.Lights;
import inz.restapiproject.repository.GroupsRepository;
import inz.restapiproject.repository.LightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsService {


    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    LightsRepository lightsRepository;

    public void saveDefaultGroup(Groups group) {
        groupsRepository.save(group);
    }


    public void saveGroup(Groups group){
        groupsRepository.save(group);
    }

    public long findIdDefaultGroup(String defaultName, long idUser){
        Groups defaultGroups = groupsRepository.findIdDefaultGroup(defaultName, idUser).get(0);
        return defaultGroups.getId();
    }

    public List<Groups> findAllGroupsForUserId(long idUser){
        return groupsRepository.findAllGroupsForUserId(idUser);
    }

}
