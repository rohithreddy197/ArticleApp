package main;

import model.Article;

import java.util.List;

public interface ArticleServiceInterface {
    public List<Article> getAllArticles();

    public Article getArticle(String id);

    public void addArticle(Article article);

    public void updateArticle(Article art, String id);

    public void deleteArticle(String id);

}
