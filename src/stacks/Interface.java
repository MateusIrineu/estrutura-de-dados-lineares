package stacks;

public interface Interface {
    
    public int size();
    
    public boolean isEmpty();
    
    public Object top() throws PilhaVaziaExcecao;
    
    public void push(Object o);
    
    public Object pop() throws PilhaVaziaExcecao;
}