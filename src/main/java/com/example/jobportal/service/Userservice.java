package com.example.jobportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.jobportal.Repository.UserRepo;
import com.example.jobportal.models.User;

@Service
public class Userservice {      
      UserRepo userrepo;
      public Userservice(UserRepo userrepo)
      {
        this.userrepo=userrepo;
      }
      public List<User>getuser()
      {
        return userrepo.findAll();
      }
    
      public Optional<User> getuserbyid( int id)
      {
        return userrepo.findById(id);
      }

      public User adduser(User addusers)
      {
         return userrepo.save(addusers);
      }
     
      public User updatUser(User userd, int id)
      {
         Optional<User> UserExcist=userrepo.findById(id);
         if(UserExcist.isPresent())
         {
            User updateuser=UserExcist.get();
             updateuser.setName(userd.getName());
             return userrepo.save(updateuser);
         }
         else
         {
            return null;
         }

      }
      public void delete(int id)
      {
        userrepo.deleteById(id);
      }
      
    
}
