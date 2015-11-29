public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j]!=0) listA.add(new Node(i,j));
            }
        }
        for (int i=0;i<B.length;i++) {
            for (int j=0;j<B[0].length;j++) {
                if (B[i][j]!=0) listB.add(new Node(i,j));
            }
        }

        for (Node nodeA : listA) {
            for (Node nodeB: listB) {
                if (nodeA.y==nodeB.x) {
                    result[nodeA.x][nodeB.y] += A[nodeA.x][nodeA.y] * B[nodeB.x][nodeB.y];
                }
            }
        }
        
        
        1234     12
        2345     23
                 34
                 45          第一行可以乘以任何一列 so A.col==B.row 
