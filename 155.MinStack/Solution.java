class MinStack {
    private List<Integer> list;
    private int min;
    public MinStack() {
        list = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;
    }
    public void push(int x) {
        list.add(x);
        if(x < min) min = x;
    }

    public void pop() {
        int r = list.remove(list.size() - 1);
        if(r == min) resetMin();
    }
    
    private void resetMin() {
        min = Integer.MAX_VALUE;
        if(list.size() != 0) {
            for(int i = 0; i < list.size(); i++) {
                if(min > list.get(i)) min = list.get(i);
            }    
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
