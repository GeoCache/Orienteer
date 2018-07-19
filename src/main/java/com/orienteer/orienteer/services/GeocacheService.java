package com.orienteer.orienteer.services;

import com.orienteer.orienteer.models.Geocache;
import com.orienteer.orienteer.models.User;
import com.orienteer.orienteer.repositories.GeoCacheRepo;
import com.orienteer.orienteer.repositories.UsersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeocacheService {
    private final GeoCacheRepo geoDao;
    private final UsersRepository usersDao;


    public GeocacheService(GeoCacheRepo geoDao, UsersRepository usersDao) {
        this.geoDao = geoDao;
        this.usersDao = usersDao;
    }




    public List<Geocache> findAll() {
        return geoDao.findAll();
    }

    public Geocache save(Geocache geocache) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.findUsersById(sessionUser.getId());
        geocache.setOwner(user);


        geoDao.save(geocache);
        return geocache;
    }



    public Geocache findById(long id) {
        return geoDao.findById(id);
    }
    public void deleteCache(long id) {geoDao.delete(id); }

    public List<Geocache> findAllByOwnerId(long id){return geoDao.findAllByOwner_Id(id);}
    public List<Geocache> findAllByFinderId(long id){return geoDao.findAllByFinder_Id(id);}

//    public void edit(Geocache geocache, long id) {
//        Geocache postUser = geoDao.findById(id);
//        User user = postUser.getOwner();
//        geocache.setOwner(user);
//        geoDao.save(geocache);
//
//    }


}