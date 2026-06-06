class MinStack {
    List<Integer> list, minList;

    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (minList.size() > 0) {
            int currentMin = minList.get(minList.size() - 1);
            minList.add(Math.min(currentMin, val));
        } else {
            minList.add(val);
        }
    }
    
    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
