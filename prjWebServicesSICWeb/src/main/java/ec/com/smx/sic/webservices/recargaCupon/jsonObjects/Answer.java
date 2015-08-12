package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author ediaz
 *
 */
public class Answer {

	@JsonInclude(value = Include.NON_EMPTY)
	private Long contentId;

	public Answer() {
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

}
