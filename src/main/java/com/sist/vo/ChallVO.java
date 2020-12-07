package com.sist.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/*
 * private int no, hit;
	private String name, subject, content, pwd;
	private Date regdate;
 */
public class ChallVO {
	 private int no, hit;
		private String name, subject, content, pwd,poster;
		private Date regdate;
		private List<MultipartFile> files;
		
		
		public List<MultipartFile> getFiles() {
			return files;
		}
		public void setFiles(List<MultipartFile> files) {
			this.files = files;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getPoster() {
			return poster;
		}
		public void setPoster(String poster) {
			this.poster = poster;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		
}
