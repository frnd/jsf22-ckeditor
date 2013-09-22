package es.frnd.ckedit;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Fernando Gonz&aacute;lez
 */
public class Page implements Serializable {
	private Long	id;
	private Date	publishDate;
	private String	title;
	private String	subtitle;
	private String	body;

	public Page(Long id, String title, String subtitle, String body) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.body = body;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        if (!id.equals(page.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
