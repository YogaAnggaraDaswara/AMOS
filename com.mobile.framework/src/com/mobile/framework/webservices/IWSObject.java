package com.mobile.framework.webservices;

import org.w3c.dom.Element;

public interface IWSObject {
	void loadXML(Element root);

	void fillXML(WSHelper ws, Element root);

	Element toXMLElement(WSHelper ws, Element root);
}
