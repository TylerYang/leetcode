import java.util.PriorityQueue;
import java.util.Comparator;
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double median = Integer.MIN_VALUE;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(median == Integer.MIN_VALUE) {
            this.median = num;
            maxHeap.add(num);
        } else {
            if(num <= median) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                reBalance();
            }
            this.median = calMedian();
        }
    }

    private void reBalance() {
        PriorityQueue<Integer> largerHeap;
        PriorityQueue<Integer> smallerHeap;
        if(minHeap.size() > maxHeap.size()) {
            largerHeap = minHeap;
            smallerHeap = maxHeap;
        } else {
            largerHeap = maxHeap;
            smallerHeap = minHeap;
        }
        while(largerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(largerHeap.poll());
        }
    }

    private double calMedian() {
        int size = minHeap.size() + maxHeap.size();

        if(size % 2 == 1) {
            if(minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(1);
        mf.addNum(1);
        System.out.println(mf.findMedian()); //0
        mf.addNum(3);
        mf.addNum(3);
        System.out.println(mf.findMedian()); //2.5: 2.0
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
