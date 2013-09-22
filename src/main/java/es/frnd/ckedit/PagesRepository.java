package es.frnd.ckedit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Fernando Gonz&aacute;lez
 */
@ManagedBean
@ApplicationScoped
public class PagesRepository implements Serializable {
	private Map<Long, Page>	pages	= new TreeMap<Long, Page>();

	@PostConstruct
	protected void init() {
		pages.put(1l, new Page(1l, "Page 1", "subtitulo", "cuerpo"));
		pages.put(2l, new Page(2l, "Page 2", "subtitulo", "cuerpo"));
		pages.put(3l, new Page(3l, "Page 3", "subtitulo", "cuerpo"));
	}

	public List<Page> getAll() {
		return new ArrayList<Page>(pages.values());
	}

	public Page get(Long id) {
		return pages.get(id);
	}

	public void saveOrUpdate(Page page) {
		if (page.getId() != null) {
			save(page);
		} else {
			update(page);
		}
	}

	private void save(Page page) {
		pages.put(page.getId(), page);
	}

	private void update(Page page) {
		page.setId(new Long(pages.size() + 1));
		pages.put(page.getId(), page);
	}

}
