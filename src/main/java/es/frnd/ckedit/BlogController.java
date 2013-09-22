package es.frnd.ckedit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class BlogController {
    List<Page> pages;
    @ManagedProperty("#{pagesRepository}")
    private PagesRepository pagesRepository;

    @PostConstruct
    public void update() {
        pages = pagesRepository.getAll();
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setPagesRepository(PagesRepository pagesRepository) {
        this.pagesRepository = pagesRepository;
    }
}
