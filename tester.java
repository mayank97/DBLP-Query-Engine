//package testing;
/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public  class tester implements test
{
	private static LinkedList<Object> observerList = new LinkedList<Object>();
	
	public static void test() throws FileNotFoundException
	{	
		long startTime = System.nanoTime();
		File xmlFile=new File("a.xml");
		userxmlparser parser= new userxmlparser();
		HashMap<Integer,dblp> users=parser.parserxml(new FileInputStream(xmlFile));
		long endTime = System.nanoTime();
		long tott=(endTime - startTime);
		tott=tott/1000000000;
		
	}
	public void registerObserver(Object Observer)
	{
		observerList.add(Observer);
	}
	public void removeObserver(Object Observer)
	{
		ListIterator<Object> iter = observerList.listIterator();
		Object obs;
		do
		{
			obs = ((ListIterator<Object>) observerList).next();
			
		}
		while(iter.hasNext() && obs != Observer);
	}
	public void notifyObserver()
	{
		ListIterator<Object> iter = observerList.listIterator();
		Object obs;
		do
		{
			obs = ((ListIterator<Object>) observerList).next();
			obs.notify();
		}
		while(iter.hasNext());
	}

}
