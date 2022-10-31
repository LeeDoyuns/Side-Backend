package com.project.backend.api.news.service;

import com.project.backend.api.news.model.domain.News;
import com.project.backend.api.news.model.domain.NewsContents;
import com.project.backend.api.news.model.domain.QNews;
import com.project.backend.api.news.model.dto.CreateNewContentsDTO;
import com.project.backend.api.news.model.dto.CreateNewDTO;
import com.project.backend.api.news.model.dto.NewsListDTO;
import com.project.backend.api.news.service.repository.NewsContentsRepository;
import com.project.backend.api.news.service.repository.NewsRepository;
import com.project.backend.api.user.model.dto.MemberSession;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService implements INewsService {

    private final JPAQueryFactory factory;

    private final EntityManager em;

    private final NewsRepository newsRepository;
    private final NewsContentsRepository newsContentsRepository;


    @Transactional
    public void createNews(CreateNewDTO param) {
        NewsContents conts  = NewsContents.builder()
                .contents(param.getContents()).updateId(param.getReporterId()).inputId(param.getReporterId())
                .build();
        newsContentsRepository.saveAndFlush(conts);

        News news = News.builder().
                title(param.getTitle()).
                contentsId(conts).
                category(param.getCategory()).
                postingTime(param.getPostingTime() != null? LocalDateTime.parse(param.getPostingTime()) : LocalDateTime.now()).
                newsStatus(param.getNewsStatus()).
                inputId(param.getReporterId()).
                updateId(param.getReporterId()).
               // hits(Integer.parseInt(param.getHits())). default 0
                build();
        newsRepository.saveAndFlush(news);

        //이미지로직 추가 news_img_rel

    }

    @Override
    public void createNewsContents(CreateNewContentsDTO newContents) {

    }

    /***
     *
     * 방법 1 : Querydsl
     */
    @Override
    public List<NewsListDTO> selectNewsList() {
        QNews news = QNews.news;
//        List<News> newList = new ArrayList<>();

        List<NewsListDTO> dtoList = factory
                .select(Projections.fields(NewsListDTO.class, // Projections.bean()은 NewsListDTO @SETTER 가 필요하다
                                                              // Projections.constructor() 생성자 순서 일치 시켜야된다.
                                                              // 참고 => https://hongdosan.tistory.com/entry/Querydsl-Projection-%EA%B3%BC-%EB%8F%99%EC%A0%81-%EC%BF%BC%EB%A6%AC
                        news.title.as ("title"),
                        news.category.as ("category"),
                        news.postingTime.as("postingTime"),
                        news.hits.as("hits")))
                .from(news)
                .where(news.postingTime.loe(now()))
                .orderBy(news.postingTime.desc()).fetch();



        return dtoList;
    }
//    @Override
//    public List<NewsListDTO> selectNewsList() {
//        QNews news = QNews.news;
////        List<News> newList = new ArrayList<>();
//
//        List<NewsListDTO> dtoList = factory.select(new QNewsnews.title.as ("title"),
//                        news.category.as ("category"),
//                        news.postingTime.as("postingTime"),
//                        news.hits.as("hits"))
//
//                .from(news)
//                .where(news.postingTime.loe(now())).fetch();
//
//
//
//        return dtoList;
//    }

    /***
     *
     * 방법 2 newsRepository로 보내서 조회
     */
//    @Override
//    public List<NewsListDTO> selectNewsList() {
//        List<News> list = newsRepository.selectNewsList();
//
//        List<NewsListDTO> dtoList = new ArrayList<>();
//        list.stream().forEach((news) -> {
//            dtoList.add(new NewsListDTO(news.getTitle()
//                    , news.getCategory()
//                    , news.getPostingTime()
//                    , news.getHits()));
//
//        });
//        return dtoList;
//    }


}





