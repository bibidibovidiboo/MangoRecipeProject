package com.sist.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Document {
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	
	
	
}
