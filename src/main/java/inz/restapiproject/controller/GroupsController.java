package inz.restapiproject.controller;


import inz.restapiproject.model.Groups;
import inz.restapiproject.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class GroupsController {

    @Autowired
    GroupsService groupsService;

    @PostMapping("/add")
    public @ResponseBody
    String addGroup(@RequestParam String name, @RequestParam String user_id){

        long iduser = Long.parseLong(user_id);

        Groups groups = new Groups();
        groups.setName(name);
        groups.setUsers_id(iduser);

        groupsService.saveGroup(groups);
        
        return "Saved";

    }

    @GetMapping("/get")
    public @ResponseBody
    List<Groups> getAllGroups(@RequestParam String user_id){
        long iduser = Long.parseLong(user_id);
        return groupsService.findAllGroupsForUserId(iduser);
    }


}
