/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.*;

public class Person extends dblp{
int counter;
HashSet<String> aka = new HashSet<String>();
public void setAuthor(String x)
	{
		aka.add(x);
	}
public HashSet getAuthorAKA()
	{	
		return aka;
	}

}
