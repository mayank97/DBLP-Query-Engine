/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;

public class Traversal implements Container {

	public String[] array = new String[400];
	   @Override
	   public Iterator getIterator() {
	      return new NameIterator();
	   }

	   private class NameIterator implements Iterator {

	      int index;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < array.length){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return array[index++];
	         }
	         return null;
	      }		
	   }
	}
