package id.trimegah.newsfeed.repository;

import id.trimegah.newsfeed.models.NewsFeedNotif;
import id.trimegah.newsfeed.models.NewsFeedNotifDetail;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class NewsFeedNotifDetailRepository  implements PanacheRepository<NewsFeedNotifDetail> {
    public List<NewsFeedNotifDetail> findByCode(String code) {
        return   find("flag", code).list();
    }
}
