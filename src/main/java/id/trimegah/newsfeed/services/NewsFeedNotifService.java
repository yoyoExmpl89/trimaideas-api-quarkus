package id.trimegah.newsfeed.services;

import id.trimegah.newsfeed.models.NewsFeedNotif;
import id.trimegah.newsfeed.repository.NewsFeedNotifRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class NewsFeedNotifService {

    @Inject
    NewsFeedNotifRepository repository;

    public List<NewsFeedNotif> getPageList(int page , int size) {
        return repository.pageList(page - 1, size);
    }

    public Long getTotal() {
        return repository.count();
    }






}
