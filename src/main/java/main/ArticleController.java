package main;

import model.Article;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RestController
@RequestMapping("articles")
public class ArticleController {
    Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping("")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @RequestMapping("/{id}")
    public Article getArticle(@PathVariable String id, HttpServletResponse response) {
        try {
            return articleService.getArticle(id);
        } catch (Exception exc) {
            logger.info("article with id not found");
            return  null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    public void addArticle(@RequestBody Article article) {
        try {
            articleService.addArticle(article);
        } catch (Exception exc) {
            logger.info("Could not add new article");

        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{id}")
    public void updateArticle(@RequestBody Article article, @PathVariable String id) {
        try {
            articleService.updateArticle(article, id);
        } catch (Exception exc) {
            logger.info("article with id not found");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    public void deleteArticle(@PathVariable String id) {
        try {
            articleService.deleteArticle(id);
        } catch (Exception exc) {
            logger.info("article with id not found to deleteit");
        }
    }
}

