package id.trimegah.newsfeed.services;

import id.trimegah.newsfeed.models.NewsFeedNotifDetail;
import id.trimegah.newsfeed.repository.NewsFeedNotifDetailRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;

@ApplicationScoped
public class NewsFeedNotifDetailService {

    @Inject
    NewsFeedNotifDetailRepository repositoryDetail;

//    @Transactional
    public NewsFeedNotifDetail create(@Valid NewsFeedNotifDetail newsFeedNotifDetail) {

        /*newsFeedNotifDetail.setPostid(newsFeedNotifDetail.getPostid().trim());
        newsFeedNotifDetail.setTitle(newsFeedNotifDetail.getTitle().trim());
        newsFeedNotifDetail.setContent(newsFeedNotifDetail.getContent().trim());
        newsFeedNotifDetail.setSubtitle(newsFeedNotifDetail.getSubtitle().trim());
        newsFeedNotifDetail.setCategory(newsFeedNotifDetail.getCategory().trim());*/
        newsFeedNotifDetail.setUnread(newsFeedNotifDetail.isUnread());
        newsFeedNotifDetail.setInsert_time(LocalDateTime.now());

        //repositoryDetail.
        repositoryDetail.persist(newsFeedNotifDetail);
        //repositoryDetail
        return newsFeedNotifDetail;
    }
}
