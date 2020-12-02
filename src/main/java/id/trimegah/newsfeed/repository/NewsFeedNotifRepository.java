package id.trimegah.newsfeed.repository;

import id.trimegah.newsfeed.models.NewsFeedNotif;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class NewsFeedNotifRepository implements PanacheRepository<NewsFeedNotif> {

    public List<NewsFeedNotif> pageList(int page, int size) {
        return find("ORDER BY id").page(page, size).list();
    }

    public List<NewsFeedNotif> listDataDetail(){
        return find("ORDER BY id").list();
    }




}
