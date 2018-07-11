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

    public List<Geocache> search(String searchCache) {
        return geoDao.findCache(searchCache, searchCache);
    }



    public Geocache findAll() {
        return (Geocache) geoDao.findAll();
    }

    public void save(Geocache geocache) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.findUsersById(sessionUser.getId());
        geocache.setOwner(user);


        geoDao.save(geocache);
    }


    public List<Geocache> findAll(long id) {
        return geoDao.findAll();
    }


    public Geocache findById(long id) {
        return geoDao.findById(id);
    }

    public void edit(Geocache geocache, long id) {
        Geocache postUser = geoDao.findById(id);
        User user = postUser.getOwner();
        geocache.setOwner(user);
        geoDao.save(geocache);

    }

    private void createCache() {
    }

}