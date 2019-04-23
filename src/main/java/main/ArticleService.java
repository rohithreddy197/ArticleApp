package main;

import model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    List<Article> articleList= new ArrayList<Article>(Arrays.asList(
            new Article("1", "name1", "desc1"),
            new Article("2", "name2", "desc2"),
            new Article("3", "name3", "desc3")

    ));
    public List<Article> getAllArticles(){
        return articleList;
    }
}
