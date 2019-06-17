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

    public Article getArticle(String id)
    {
        return articleList.stream().filter(t-> t.getId().equals(id)).findFirst().get();
    }
    public void addArticle(Article article) {
        articleList.add(article);
    }


    public void updateArticle(Article art, String id) {

        for(int i=0;i<articleList.size();i++)
        {
            Article article =articleList.get(i);
            if(article.getId().equals(id))
            {
                articleList.set(i,art);
            }
        }
    }

    public void deleteArticle(String id) {
        articleList.removeIf(t->t.getId().equals(id));
    }
}

