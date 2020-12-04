package inz.restapiproject.controller;


import inz.restapiproject.model.Groups;
//import inz.restapiproject.model.GroupsHasLights;
import inz.restapiproject.model.Lights;
import inz.restapiproject.model.Users;
//import inz.restapiproject.service.GroupsHasLightsService;
import inz.restapiproject.service.GroupsService;
import inz.restapiproject.service.LightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/lights")
public class LightsController {

    @Autowired
    LightsService lightsService;

    @Autowired
    GroupsService groupsService;

//    @Autowired
//    GroupsHasLightsService groupsHasLightsService;

    /*
    @GetMapping("/all")
    public @ResponseBody
    List<Lights> getLights(){
        return lightsService.getUsers();
    }

     */

    @PostMapping("/add")
    public @ResponseBody String addLight(@RequestParam String serial, @RequestParam String name, @RequestParam String user_id){

            long idUser = Long.parseLong(user_id);

            Lights n = new Lights();
            n.setSerial(serial);
            n.setName(name);

            lightsService.savelight(n);

            long idLight = n.getId();

            long defaultGroupId = groupsService.findIdDefaultGroup("Wszystkie urządzenia", idUser);
            System.out.println(defaultGroupId);

            List<Groups> groupsList = groupsService.findAllGroupsForUserId(idUser);

            for (Groups group: groupsList) {
                if(group.getId() == defaultGroupId) {
                    group.getLights().add(n);
                    groupsService.saveGroup(group);
                    break;
                }

            }

            return "Saved";

    }

    @GetMapping("/get")
    public @ResponseBody List<Lights> getLights(@RequestParam String user_id){

            long idUser = Long.parseLong(user_id);


            return lightsService.findLights(idUser);
    }

}
