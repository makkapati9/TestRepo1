package com.avd.common.util;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser {
	

	private String data = "";

	public String parser(String adharId) throws Exception {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		
		
		parser.parse(new File("C:/pdf_report/responseXML/" + adharId + ".xml"), handler);

		// Printing the list of employees obtained from XML
		for (AdharUserData emp : handler.adharList) {
			data = emp.toString();
		}
		//System.out.println(data);
		return data;
	}
}

/**
 * The Handler for SAX Events.
 */
class SAXHandler extends DefaultHandler {

	List<AdharUserData> adharList = new ArrayList<AdharUserData>();
	AdharUserData adhar = new AdharUserData();
	String content = null;

	@Override
	// Triggered when the start of tag is found.
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		
		// Create a new Employee object when the start tag is found

		if ("ekycRes".equals(qName)) {
			adhar.txn = attributes.getValue("txn");
			adhar.err = attributes.getValue("err");
		}
		
		if ("poi".equals(qName)) {
		  
	
			adhar.name = attributes.getValue("name");
			adhar.dob = attributes.getValue("dob");
			adhar.email = attributes.getValue("email");
			adhar.phone = attributes.getValue("phone");
			adhar.sex = attributes.getValue("sex");
		}
		
		
		if ("poa".equals(qName)) {
			  
			
			adhar.co = attributes.getValue("co");
			adhar.houseno = attributes.getValue("houseno");
			adhar.street = attributes.getValue("street");
			adhar.landmark = attributes.getValue("landmark");
			adhar.locality = attributes.getValue("locality");
			adhar.vtc = attributes.getValue("vtc");
			adhar.po = attributes.getValue("po");
			adhar.distict = attributes.getValue("distict");
			adhar.subdistict = attributes.getValue("subdistict");
			adhar.state = attributes.getValue("state");
			adhar.pincode = attributes.getValue("pincode");
		}
		
		if ("pht".equals(qName)) 
		{
					  
			adhar.photo = attributes.getValue("photo");
		}
		
		if ("lpoa".equals(qName)) 
		{
					  
			adhar.nameHindi = attributes.getValue("name");
			adhar.coHindi = attributes.getValue("co");
			adhar.houseNoHindi = attributes.getValue("houseno");
			adhar.streetHindi = attributes.getValue("street");
			adhar.landmarkHindi = attributes.getValue("landmark");
			adhar.localityHindi = attributes.getValue("locality");
		}
				
	
}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if ("ekycRes".equals(qName)) {
			adharList.add(adhar);
			
		}
		
		if ("poi".equals(qName)) {
			adharList.add(adhar);
			
		}
		

		if ("poi".equals(qName)) {
			adharList.add(adhar);
			
		}
		

		if ("poa".equals(qName)) {
			adharList.add(adhar);
			
		}
		

		if ("poi".equals(qName)) {
			adharList.add(adhar);
			
		}
		

		if ("pht".equals(qName)) {
			adharList.add(adhar);
			
		}
		
		if ("lpoa".equals(qName)) {
			adharList.add(adhar);
			
		}
		
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}

class AdharUserData {

	String name;
	String dob;
	String sex;
	String phone;
	String email;
	String co;
	String houseno;
	String street;
	String landmark;
	String locality;
	String vtc;
	String po;
	String distict;
	String subdistict;
	String state;
	String pincode;
	String photo;
	String nameHindi;
	String coHindi;
	String houseNoHindi;
	String streetHindi;
	String landmarkHindi;
	String localityHindi;
	String txn;
	String err;
	
	@Override
	public String toString() {
		return name + "#" + dob + "#" + sex + "#" + phone + "#" + email + "#"
				+ co + "#" + houseno + "#" + street + "#" + landmark + "#"
				+ locality + "#" + vtc + "#" + po + "#" + distict + "#"
				+ subdistict + "#" + state + "#" + pincode + "#" + photo + "#"
				+ nameHindi + "#" + coHindi + "#" + houseNoHindi + "#"
				+ streetHindi + "#" + landmarkHindi + "#" + localityHindi+"#"+txn +"#"+err;
	}
}