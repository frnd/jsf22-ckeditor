package es.frnd.ckedit;

import org.omnifaces.util.Faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class PageController {
    @ManagedProperty("#{pagesRepository}")
    private PagesRepository pagesRepository;
    private Long selectedId;
    private Page selectedPage;
    private boolean saved = false;

    public void loadPage() {
        selectedPage = pagesRepository.get(selectedId);
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public Page getSelectedPage() {
        return selectedPage;
    }

    @SuppressWarnings("UnusedParameters")
    public void saveEdit(ActionEvent event) {
        String title = Faces.getRequestParameter("title");
        String subtitle = Faces.getRequestParameter("subtitle");
        String body = Faces.getRequestParameter("body");

        selectedPage.setTitle(title);
        selectedPage.setSubtitle(subtitle);
        selectedPage.setBody(body);

        pagesRepository.saveOrUpdate(selectedPage);
        saved= true;
    }

    public boolean isSaved() {
        return saved;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setPagesRepository(PagesRepository pagesRepository) {
        this.pagesRepository = pagesRepository;
    }
}
