//package testing;
//package dblp;
package dblp;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class userxmlparser {
static HashMap<Integer,dblp>articles=new HashMap<Integer,dblp>();
static ArrayList<dblp>personrec=new ArrayList<dblp>();


public  HashMap parserxml(InputStream in){
	
	try{
		parserhandler handler= new parserhandler();
		XMLReader parser=XMLReaderFactory.createXMLReader();
		parser.setContentHandler(handler);
		//parser.set
		parser.parse("a.xml");
		articles=handler.getUsers();
		personrec=handler.getPerson();
		//handler.print();
		//dblp q=
ArrayList <dblp> newarray=new ArrayList<dblp>();
	//newarray=SearchbyAuthor(articles,"Parallel");
	Article llll=(Article)articles.get(7);
	System.out.println(llll.getothernames());
		
	}
	catch(SAXException  e){
		e.printStackTrace();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return articles;
}
	
	public static TreeSet<String> SearchbyPublication(int number)
	{
		HashMap<String, Integer> kpub = new HashMap<String, Integer>();
		System.out.println("Hash Pub Search");
		int ll = 1;
		
		for(ll=1;ll<=parserhandler.num;ll++)
		{
			dblp newa=articles.get(ll); 
			
			if(newa instanceof Article)
			{
				Article temp = (Article) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof Book)
			{
				Book temp = (Book) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof Incollection)
			{
				Incollection temp = (Incollection) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof Inproceedings)
			{
				Inproceedings temp = (Inproceedings) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof MasterThesis)
			{
				MasterThesis temp = (MasterThesis) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof PHDThesis)
			{
				PHDThesis temp = (PHDThesis) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else if(newa instanceof Proceedings)
			{
				Proceedings temp = (Proceedings) newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}
			else 
			{
				WebPage temp = (WebPage)newa;
				if(!(kpub.containsKey(temp.getAuthor())))
				{
					kpub.put(temp.getAuthor(), (Integer)1);
				}
				else
				{
					Integer add = 1;
					kpub.put(temp.getAuthor(), kpub.get(temp.getAuthor()) + add);
				}
			}

						
				
				
			}
		/*
		System.out.println(kpub);
		System.out.println(kpub.size());
		System.out.println("---------------------------");
		
		*/
			TreeSet<String> tree = new TreeSet<String>();
			
				for(String key : kpub.keySet())
				{
					if(kpub.get(key) >= number)
					{
						tree.add(key);
					}
				}
/*				System.out.println(tree);
				System.out.println(tree.size());
	*/	return tree;
		
		
		
		
	}
	
	public static TreeSet<String> SearchAllPublications(String author, String year)
	{
		TreeSet<String> tree = new TreeSet<String>();
		int ll=1;int z=0;
		
		for(ll=1;ll<parserhandler.num;ll++)
		{
			
			dblp newa=articles.get(ll);
			int numb = Integer.parseInt((String) newa.getYear());
			int numb2 = Integer.parseInt(year);
			if(newa.getAuthor().equals(author) && numb < numb2)
			{
				
				tree.add((String) newa.getYear());
			}
		}
	
		
		
		return tree;
	}
	
public static ArrayList SearchbyTitle(String x){
		
		ArrayList <dblp> newarray=new ArrayList<dblp>();
		String b=x;
				System.out.println("Seaching");
				int ll=1;int z=0;
				for(ll=1;ll<=parserhandler.num;ll++){
					dblp newa=articles.get(ll);
				if(newa instanceof Article)
				{
					Article a= (Article)newa;
					String c=a.getTitle();
					
					if(c.contains(b)){z++;
						newarray.add(a);
									
						
					System.out.println("-----------------------------------------------");	
					}

				}
				else if(newa instanceof Book)
				{
					Book a= (Book)newa;
					String c=a.getTitle();
				
					if(c.contains(b)){
						System.out.println(a);z++;
						newarray.add(a);
						
					System.out.println("-----------------------------------------------");	
					}
				}
				else if(newa instanceof WebPage)
				{
					WebPage a= (WebPage)newa;
					String c=a.getTitle();
					
					if(c.contains(b)){
						System.out.println(a);
							newarray.add(a);						
							z++;
					System.out.println("-----------------------------------------------");	
					}
					}
				else if(newa instanceof Proceedings)
				{
					Proceedings a= (Proceedings)newa;
					String c=a.getAuthor();
					z++;
					if(c.contains(b)){
						System.out.println(a);
						z++;
							newarray.add(a);
					System.out.println("-----------------------------------------------");	
					}
				}
				else if(newa instanceof PHDThesis)
				{
					PHDThesis a= (PHDThesis)newa;
					String c=a.getTitle();
					if(c.contains(b)){
						System.out.println(a);
						z++;
						newarray.add(a);
					System.out.println("-----------------------------------------------");	
					}
				}
				else if(newa instanceof MasterThesis)
				{
					MasterThesis a= (MasterThesis)newa;
					String c=a.getTitle();
					if(c.contains(b)){
						System.out.println(a);
							newarray.add(a);
						z++;
					System.out.println("-----------------------------------------------");	
					}
				}
				else if(newa instanceof Inproceedings)
				{
					Inproceedings a= (Inproceedings)newa;
					String c=a.getTitle();
					if(c.contains(b)){
						System.out.println(a);
						newarray.add(a);
						z++;
					System.out.println("-----------------------------------------------");	
					}
				}
				else if(newa instanceof Incollection)
				{
					Incollection a= (Incollection)newa;
					String c=a.getTitle();
					if(c.contains(b)){
						System.out.println(a);
						newarray.add(a);
						z++;
					System.out.println("-----------------------------------------------");	
					}
				}
				

				
					}
			System.out.println(z);
System.out.println(newarray.size());
System.out.println(newarray);
return newarray;
			}



public static ArrayList SearchbyAuthor(String x){
		
		ArrayList <dblp> newarray=new ArrayList<dblp>();
	
		ArrayList <String>variablestorage=new ArrayList<String>();
		HashSet <String>temporary=new <String> HashSet();
		for(dblp per:personrec)
		{	Person p=(Person)per;	
			temporary=p.getAuthorAKA();
			if(temporary.contains(x)){
				for(String tempstr:temporary)
					{ 
						variablestorage.add(tempstr);
					}
			}
		}		//System.out.println("hashset"+temporary);
				//System.out.println("Seaching");
				//System.out.println(variablestorage);
		int ll=1;int z=0;
				for(ll=1;ll<=parserhandler.num;ll++){
					dblp newa=articles.get(ll);
				if(newa instanceof Article)
				{
					Article a= (Article)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof WebPage)
				{
					WebPage a= (WebPage)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof Proceedings)
				{
					Proceedings a= (Proceedings)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof Article)
				{
					PHDThesis a= (PHDThesis)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof MasterThesis)
				{
					MasterThesis a= (MasterThesis)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof Inproceedings)
				{
					Inproceedings a= (Inproceedings)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof Incollection)
				{
					Incollection a= (Incollection)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
				if(newa instanceof Book)
				{
					Book a= (Book)newa;
					String c=a.getAuthor();
					if(c.contains(x)){
						System.out.println(a);z++;
						newarray.add(a);
				
					ArrayList <String>subarraylist=a.getothernames();
					String [] starray=new String[subarraylist.size()+1];int lm=0;
					for(String pp:starray){lm++;}
					//System.out.println(lm++);
					starray[subarraylist.size()]=c;
					int mood=0;
					for(String b:variablestorage){
						//System.out.println("inside firstloop");
						if(mood==0){
					for(int j =0;j<subarraylist.size();j++){
		 				 starray[j] = subarraylist.get(j);
						//System.out.println(starray[j]);
						
						if(starray[j].contains(b)){
							newarray.add(a);mood++;
						System.out.println("matchfound");
			
					
								}
							}
						}
					
					}
					}
				}
		
					}
				return newarray;

}}		




	
	
	
	
	
	
	
	
	
	
	

