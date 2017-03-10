/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
//package testing;
package dblp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parserhandler extends DefaultHandler {
	static int num1= 0;
static int num2= 0;
static int num3= 0;
static int num4= 0;
static int num5= 0;
static int num6= 0;
static int num7= 0;
static int num8= 0;
static int num= 0;
static int store=0;
	// This is the list which shall be populated while parsing the XML.
	private HashMap<Integer, dblp> userList = new HashMap<Integer, dblp>();
	private ArrayList<dblp> personrecords=new ArrayList<dblp>();
	// As we read any XML element we will push that in this stack
	private Stack<String> elementStack = new Stack<String>();

	// As we complete one user block in XML, we will push the User instance in
	// userList
	private Stack<dblp> objectStack = new Stack<dblp>();

	public void startDocument() throws SAXException {
		System.out.println("start of the document   : ");
	}

	public void endDocument() throws SAXException {
		System.out.println("end of the document document     : ");
		System.out.println("tot "+num)	;	
	System.out.println("article "+num1);
		System.out.println("book "+num2);
		System.out.println("incollection "+num3);
		System.out.println("inproceedings "+num4);
		System.out.println("master "+num5);
		System.out.println("phd "+num6);
		System.out.println("proceedings"+num7);
		System.out.println("www "+num8);
		System.out.println("personrec"+personrecords.size());
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Push it in element stack
		this.elementStack.push(qName);

		if ("article".equals(qName.toLowerCase())) {
			// New User instance
			Article user = new Article();
			this.objectStack.push(user);
			//num1++;
			//System.out.println("pushing");
		}
		if ("book".equals(qName.toLowerCase())) {
			// New User instance
			Book user = new Book();
			this.objectStack.push(user);
			//num2++;
		}
		if ("incollection".equals(qName.toLowerCase())) {
			// New User instance
			Incollection user = new Incollection();
			this.objectStack.push(user);
		//	//num3++;
		}
		if ("inproceedings".equals(qName.toLowerCase())) {
			// New User instance
			Inproceedings user = new Inproceedings();
			this.objectStack.push(user);
		//	num4++;
		}
		if ("mastersthesis".equals(qName.toLowerCase())) {
			MasterThesis user = new MasterThesis();
			this.objectStack.push(user);
			//num5++;
		}
		if ("phdthesis".equals(qName.toLowerCase())) {
			// New User instance
			PHDThesis user = new PHDThesis();
			this.objectStack.push(user);
			//num6++;
		}
		if ("proceedings".equals(qName.toLowerCase())) {
			// New User instance
			Proceedings user = new Proceedings();
			this.objectStack.push(user);
		//	num7++;
		}
		if ("www".equals(qName)) {
			int checker=0;
			for (int i = 0; i < attributes.getLength(); i++) {
                   
                   	 String attrVal = attributes.getValue(i);
                   	if(attrVal.contains("homepages/"))
				{
					Person user=new Person();
					this.objectStack.push(user);
					checker++;
				} 
                	}
			if(checker==0){
				WebPage user = new WebPage();
				this.objectStack.push(user);
			}
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		// Remove last added </user> element
		if (elementStack.empty() != true) {
			this.elementStack.pop();
		}

		// User instance has been constructed so pop it from object stack and
		// push in userList
		dblp var=null;
		
		if ("article".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
				dblp var1=this.objectStack.pop();
			num++;num1++;
			if(num1==1)
			{
				store=num1;
			}
			this.userList.put(num, var1);
			//System.out.println("pop");
			}

			}
			
		
		if ("book".equals(qName.toLowerCase())) {
			
			if(!objectStack.isEmpty())
				{dblp var1=this.objectStack.pop();
			num++;num2++;
			this.userList.put(num, var1);
			//System.out.println("pop");
			}}

		if ("incollection".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
			dblp var1=this.objectStack.pop();
			num++;num3++;
			this.userList.put(num, var1);
			//System.out.println("pop");
			}
		}
		if ("inproceedings".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
			dblp var1=this.objectStack.pop();
			num++;num4++;
			this.userList.put(num, var1);
			//System.out.println("pop");
			}
		}
		if ("mastersthesis".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
			dblp var1=this.objectStack.pop();
			num++;num5++;
			this.userList.put(num, var1);
			//System.out.println("pop");
			}
		}
		if ("phdthesis".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
			dblp var1=this.objectStack.pop();
			num++;num6++;
			this.userList.put(num, var1);
			//System.out.println("pop");
		}}
		if ("proceedings".equals(qName.toLowerCase())) {
			if(!objectStack.isEmpty()){
				dblp var1=this.objectStack.pop();
			
			num++;num7++;
			this.userList.put(num, var1);
			
			}
		}
		if ("www".equals(qName)) {
			if(!objectStack.isEmpty()){
			if(objectStack.peek() instanceof WebPage){
			dblp var1=this.objectStack.pop();
			num++;num8++;
			this.userList.put(num, var1);
			}
			else {
				dblp var1=this.objectStack.pop();
				this.personrecords.add(var1);
				}
			}
		}

	}

	/**
	 * This will be called everytime parser encounter a value node
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch, start, length).trim();

		if (value.length() == 0) {
			return; // ignore white space
		}

		// handle the value based on to which element it belongs
		// set title
		if ("title".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof Inproceedings) {
					Inproceedings user = (Inproceedings) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof MasterThesis) {
					MasterThesis user = (MasterThesis) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setTitle(value);
				} else if (this.objectStack.peek() instanceof WebPage) {
					WebPage user = (WebPage) this.objectStack.peek();
					user.setTitle(value);
				}
			}
		} // set author name in objects
		else if ("author".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Inproceedings) {
					Inproceedings user = (Inproceedings) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof MasterThesis) {
					MasterThesis user = (MasterThesis) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof WebPage) {
					WebPage user = (WebPage) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Person) {
					Person user = (Person) this.objectStack.peek();
					user.setAuthor(value);
				}
			}
		}
		// set pages in years
		else if ("pages".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setPages(value);
				}
				if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setPages(value);
				}
				if (this.objectStack.peek() instanceof Inproceedings) {
					Inproceedings user = (Inproceedings) this.objectStack.peek();
					user.setPages(value);
				}
			}
		}
		// set years in objects
		else if ("year".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Inproceedings) {
					Inproceedings user = (Inproceedings) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof MasterThesis) {
					MasterThesis user = (MasterThesis) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setYear(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof WebPage) {
					WebPage user = (WebPage) this.objectStack.peek();
					user.setYear(value);
				}
			}
		}
		// volume
		else if ("volume".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setVolume(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setVolume(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setVolume(value);
				}
			} // set journal
		} else if ("journal".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setJournal(value);
				}
			}
			// set number
		} else if ("number".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setNumber(value);
				}
			}
			// set url
		} else if ("url".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setUrl(value);
				}
			} // set ee
		} else if ("ee".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Article) {
					Article user = (Article) this.objectStack.peek();
					user.setEE(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setEE(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setEE(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setEE(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setEE(value);
				}
			}

		} // set editor
		else if ("editor".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setEditor(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setEditor(value);
				}
			}

		} // set series
		else if ("series".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setSeries(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setSeries(value);
				}
			}

		} // set publisher
		else if ("publisher".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setPublisher(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setPublisher(value);
				}
			}
		} // set isbn
		else if ("isbn".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Book) {
					Book user = (Book) this.objectStack.peek();
					user.setISBN(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Proceedings) {
					Proceedings user = (Proceedings) this.objectStack.peek();
					user.setISBN(value);
				}
			}
		} // set crossref
		else if ("crossref".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Incollection) {
					Incollection user = (Incollection) this.objectStack.peek();
					user.setCrossref(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof Inproceedings) {
					Inproceedings user = (Inproceedings) this.objectStack.peek();
					user.setCrossref(value);
				}
			}
		} // set school variable
		else if ("school".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof MasterThesis) {
					MasterThesis user = (MasterThesis) this.objectStack.peek();
					user.setSchool(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setSchool(value);
				}
			}
		}
		// set note variable
		else if ("note".equals(currentElement())) {
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof PHDThesis) {
					PHDThesis user = (PHDThesis) this.objectStack.peek();
					user.setNote(value);
				}
			}
			if (objectStack.empty() != true) {
				if (this.objectStack.peek() instanceof WebPage) {
					WebPage user = (WebPage) this.objectStack.peek();
					user.setNote(value);
				}
			}
		}

	}

	/**
	 * Utility method for getting the current element in processing
	 */
	private String currentElement() {
		return this.elementStack.peek();
	}

	// Accessor for userList object
	public HashMap<Integer, dblp> getUsers() {
		return userList;
	}
public ArrayList<dblp> getPerson() {
		return personrecords;
	}

	public void print() {
		// TODO Auto-generated method stub

	}
}
