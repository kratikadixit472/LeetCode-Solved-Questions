class Solution {
    
    int[] root;
    int component;
    
    private int findPar(int u){
        return (root[u] == u) ? u : (root[u] = findPar(root[u]));
    }
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        component = n;
        root = new int[n];
        for(int i = 0; i < n; i++) root[i] = i;
        
        for(int i =0 ; i < n; i++){
            
            if(leftChild[i] >= 0 && !union(i, leftChild[i] )) return false;
            
            if(rightChild[i] >= 0 && !union(i, rightChild[i] )) return false;
            
            
        }
        return (component == 1);
    }
    
    private boolean union(int parent, int child ){
        
        int rootParent = findPar(parent);
        int rootChild = findPar(child);
        
        if(rootParent == rootChild || child != rootChild) return false;
        
        root[child] = parent;
        component--;
        return true;
    }
}