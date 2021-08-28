
// Method 1: brute force
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> arr = null;
    private int idx = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.arr =  new ArrayList<>();
        flatten(nestedList, arr);
    }
    
    private void flatten(List<NestedInteger> nestedList, List<Integer> arr) {
        if (nestedList == null) return;
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                arr.add(nested.getInteger());
            } else {
                flatten(nested.getList(), arr);
            }
        }
    }

    @Override
    public Integer next() {
        Integer res = arr.get(idx);
        idx++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return idx < arr.size();
    }
}

// Method 2 : stack, keep all NestedInteger in the stack, Note when check hasNext() we pop out List of NestedInteger then push all nestedInteger in stack again
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<NestedInteger> stack = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        prepareStack(nestedList);
    }
    
    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            prepareStack(list);
        }
        return !stack.isEmpty();
    }
}
