package com.orienteer.orienteer.repositories;

        import com.orienteer.orienteer.models.Geocache;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;


public interface GeoCacheRepo extends CrudRepository<Geocache, Long> {

    List<Geocache> findAll();

    List<Geocache> findCache(
            long createdTime, String name, String type,
            String locationName, String isActive, String points);

    Geocache findById(long id);


    List<Geocache> findCache(String searchCache, String searchCache1);
}
