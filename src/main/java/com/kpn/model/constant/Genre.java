package com.kpn.model.constant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "genre")
@XmlAccessorType(XmlAccessType.FIELD)
public enum Genre {

	Action, Comedy, Drama, Thriller
}
