// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.Iterator;
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer nextPeek;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
        if(it.hasNext()) nextPeek = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextPeek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer nextVal = nextPeek;
        if(it.hasNext()) {
            nextPeek = it.next();
        } else {
            nextPeek = null;
        }
        return nextVal;
	}

	@Override
	public boolean hasNext() {
        return nextPeek != null;
	}
    @Override 
    public void remove() {
    }
}
