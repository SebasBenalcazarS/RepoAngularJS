package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import org.springframework.http.MediaType;

public class File {
	private Long fileId;
	private byte[] file;
	private MediaType contentType;
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public MediaType getContentType() {
		return contentType;
	}
	public void setContentType(MediaType contentType) {
		this.contentType = contentType;
	}
	
	
}
