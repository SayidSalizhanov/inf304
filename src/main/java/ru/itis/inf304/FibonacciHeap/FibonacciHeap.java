package ru.itis.inf304.FibonacciHeap;

import java.util.*;

import static java.lang.Math.*;

public final class FibonacciHeap {

    // Константа фи. Используется в формуле Бине. Эта формула позволяет вычислить число Фибоначчи без рекурсии.
    private static final double LOG_PHI = log( ( 1 + sqrt( 5 ) ) / 2 );

    // Хранения уникальных значений элементов кучи.
    private Set<Integer> keys = new HashSet<>();

    // Количество элементов в куче. {@code n[H]}
    private int size = 0;

    // Количество деревьев в листе. {@code t(H)}
    private int trees = 0;

    // Количество помеченных нод. {@code m(H)}
    private int markedNodes = 0;

    // Минимальная нода. {@code min[H]}
    private Node minimumNode;

    // Количество операций (для измерений).
    private int count;

    // Перемещает целевую ноду в корневые ноды.
    // Используется в #add(Object)
    // Используется в #consolidate()
    // Используется в #cut(Node, Node)
    private void moveToRoot(Node node) {
        if (isEmpty()) {
            minimumNode = node;
        }
        else {
            node.setRight(minimumNode);
            node.setLeft(minimumNode.getLeft());
            minimumNode.setLeft(node);
            node.getLeft().setRight(node);

            if (compare(node, minimumNode) < 0) {
                minimumNode = node;
            }
        }
    }

    public boolean insert( Integer e ) {
        if (e == null) {
            throw new NullPointerException();
        }

        Node node = new Node(e);

        moveToRoot(node);

        size++;

        keys.add(e);

        return true;
    }

    public void clear() {
        minimumNode = null;
        size = 0;
        trees = 0;
        markedNodes = 0;
        keys.clear();
    }

    public boolean contains( Object o ) {
        if ( o == null ) {
            return false;
        }

        return keys.contains( o );
    }

    public boolean isEmpty() {
        return minimumNode == null;
    }

    public int size() {
        return size;
    }

    public Integer getMinKey() {
        if ( isEmpty() ) {
            return null;
        }

        return minimumNode.getKey();
    }

    public Node getMin() {
        if ( isEmpty() ) {
            System.out.println("Куча пуста");
        }

        return minimumNode;
    }

    public void decreaseKey(Node x, Integer newKey) {
        if (newKey > x.getKey()) {
            throw new IllegalArgumentException("Новый ключ больше текущего ключа");
        }

        x.setKey(newKey);
        Node y = x.getParent();

        if (y != null && x.getKey() < y.getKey()) {
            cut(x, y);
            cascadingCut(y);
        }

        if (x.getKey() < minimumNode.getKey()) {
            minimumNode = x;
        }
    }

    public Integer extractMin() {
        if ( isEmpty() ) {
            return null;
        }

        Node z = minimumNode;
        int numOfKids = z.getDegree();

        Node x = z.getChild();
        Node tempRight;

        while ( numOfKids > 0 ) {
            tempRight = x.getRight();

            moveToRoot( x );

            x.setParent( null );

            x = tempRight;
            numOfKids--;
        }

        z.getLeft().setRight( z.getRight() );
        z.getRight().setLeft( z.getLeft() );

        if ( z == z.getRight() ) {
            minimumNode = null;
        }
        else {
            minimumNode = z.getRight();
            consolidate();
        }

        size--;

        Integer minimum = z.getKey();
        keys.remove( minimum );
        return minimum;
    }

    private void consolidate() {
        if ( isEmpty() ) {
            return;
        }

        int arraySize = ( (int) floor( log( size ) / LOG_PHI ) );

        List<Node> nodeSequence = new ArrayList<>( arraySize );
        for ( int i = 0; i < arraySize; i++ ) {
            nodeSequence.add( i, null );
        }

        int numRoots = 0;

        Node x = minimumNode;

        if ( x != null ) {
            numRoots++;
            x = x.getRight();

            while ( x != minimumNode ) {
                numRoots++;
                x = x.getRight();
            }
        }

        while ( numRoots > 0 ) {
            int degree = x.getDegree();
            Node next = x.getRight();

            while ( nodeSequence.get( degree ) != null ) {
                Node y = nodeSequence.get( degree );

                if ( compare( x, y ) > 0 ) {
                    Node pointer = y;
                    y = x;
                    x = pointer;
                }

                link( y, x );

                nodeSequence.set( degree, null );

                degree++;
            }

            nodeSequence.set( degree, x );

            x = next;
            numRoots--;
        }

        minimumNode = null;

        for ( Node pointer : nodeSequence ) {
            if ( pointer == null ) {
                continue;
            }
            if ( minimumNode == null ) {
                minimumNode = pointer;
            }

            if ( minimumNode != null ) {
                moveToRoot( pointer );
            }
        }
    }

    private void link( Node y, Node x ) {
        y.getLeft().setRight( y.getRight() );
        y.getRight().setLeft( y.getLeft() );

        y.setParent( x );

        if ( x.getChild() == null ) {
            x.setChild( y );
            y.setRight( y );
            y.setLeft( y );
        }
        else {
            y.setLeft( x.getChild() );
            y.setRight( x.getChild().getRight() );
            x.getChild().setRight( y );
            y.getRight().setLeft( y );
        }

        x.increaseDegree();

        y.setMarked( false );
        markedNodes++;
    }

    private void cut( Node x, Node y ) {
        moveToRoot( x );

        y.decreaseDegree();
        x.setParent( null );

        x.setMarked( false );
        markedNodes--;
    }

    private void cascadingCut( Node y ) {
        Node z = y.getParent();

        if ( z != null ) {
            if ( !y.isMarked() ) {
                y.setMarked( true );
                markedNodes++;
            }
            else {
                cut( y, z );
                cascadingCut( z );
            }
        }
    }

    public void merge(FibonacciHeap h2) {
        if (minimumNode == null) {
            minimumNode = h2.minimumNode;
        } else if (h2.minimumNode != null) {
            this.minimumNode.getRight().setLeft(h2.minimumNode.getLeft());
            h2.minimumNode.getLeft().setRight(this.minimumNode.getRight());
            this.minimumNode.setRight(h2.minimumNode);
            h2.minimumNode.setLeft(this.minimumNode);

            if (h2.minimumNode.getKey() < minimumNode.getKey()) {
                minimumNode = h2.minimumNode;
            }
        }

        size += h2.size;
        trees += h2.trees;
        keys.addAll(h2.keys);
        markedNodes += h2.markedNodes;
    }

    private int compare( Node o1, Node o2 ) {
        return o1.getKey().compareTo( o2.getKey() );
    }

    public String toString() {
        if ( minimumNode == null ) {
            return "FibonacciHeap=[]";
        }

        Stack<Node> stack = new Stack<>();
        stack.push( minimumNode );

        StringBuilder buf = new StringBuilder( "FibonacciHeap=[" );

        while ( !stack.empty() ) {
            Node curr = stack.pop();
            buf.append( curr );
            buf.append( ", " );

            if ( curr.getChild() != null ) {
                stack.push( curr.getChild() );
            }

            Node start = curr;
            curr = curr.getRight();

            while ( curr != start ) {

                buf.append( curr );
                buf.append( ", " );

                if ( curr.getChild() != null ) {
                    stack.push( curr.getChild() );
                }

                curr = curr.getRight();
            }
        }

        buf.append( ']' );

        return buf.toString();
    }

    // те же методы, но с подсчетом количества вычислений

    public TimeAndNumOfOperations insertWithTimeAndOperations( Integer e ) {

        long begin = System.nanoTime();

            if (e == null) {
                count++;
                throw new IllegalArgumentException("Null elements not allowed in this FibonacciHeap implementation.");
            }

            Node node = new Node(e);

            if (isEmpty()) {
                minimumNode = node; count++;
            }
            else {
                node.setRight(minimumNode);
                node.setLeft(minimumNode.getLeft());
                minimumNode.setLeft(node);
                node.getLeft().setRight(node);

                if (compare(node, minimumNode) < 0) {
                    minimumNode = node; count++;
                }

                count+=8;
            }

            size++;
            keys.add(e);

            count+=5;

        long end = System.nanoTime();

        TimeAndNumOfOperations result = new TimeAndNumOfOperations(end - begin, count);

        count = 0;

        return result;
    }

    public TimeAndNumOfOperations getMinWithTimeAndOperations() {
        Node example;

        long begin = System.nanoTime();

            example = getMin();

        long end = System.nanoTime();

        count += 2; // (оператор if) + (оператор return)

        TimeAndNumOfOperations result = new TimeAndNumOfOperations(end - begin, count);

        count = 0;

        return result;
    }

    public TimeAndNumOfOperations extractMinWithTimeAndOperations() {

        long begin = System.nanoTime();

            if ( isEmpty() ) {
                return null;
            }

            Node z = minimumNode;
            int numOfKids = z.getDegree();

            Node x = z.getChild();
            Node tempRight;

            while ( numOfKids > 0 ) {
                tempRight = x.getRight();

                if (isEmpty()) {
                    minimumNode = x; count++;
                }
                else {
                    x.getLeft().setRight(x.getRight());
                    x.getRight().setLeft(x.getLeft());

                    x.setLeft(minimumNode);
                    x.setRight(minimumNode.getRight());
                    minimumNode.setRight(x);
                    x.getRight().setLeft(x);

                    if (compare(x, minimumNode) < 0) {
                        minimumNode = x; count++;
                    }

                    count+=14;
                }

                x.setParent( null );

                x = tempRight;
                numOfKids--;

                count+=7;
            }

            z.getLeft().setRight( z.getRight() );
            z.getRight().setLeft( z.getLeft() );

            if ( z == z.getRight() ) {
                minimumNode = null; count++;
            }
            else {
                minimumNode = z.getRight();

                if ( !isEmpty() ) {
                    int arraySize = ( (int) floor( log( size ) / LOG_PHI ) );

                    List<Node> nodeSequence = new ArrayList<>( arraySize );
                    for ( int i = 0; i < arraySize; i++ ) {
                        nodeSequence.add( i, null );
                    }
                    count+=arraySize;

                    int numRoots = 0;

                    Node nd = minimumNode;

                    numRoots++;
                    nd = nd.getRight();

                    while ( nd != minimumNode ) {
                        numRoots++;
                        nd = nd.getRight();

                        count+=4;
                    }

                    while ( numRoots > 0 ) {
                        int degree = nd.getDegree();
                        Node next = nd.getRight();

                        while ( nodeSequence.get( degree ) != null ) {
                            Node y = nodeSequence.get( degree );

                            if ( compare( nd, y ) > 0 ) {
                                Node pointer = y;
                                y = nd;
                                nd = pointer;

                                count+=3;
                            }

                            y.getLeft().setRight( y.getRight() );
                            y.getRight().setLeft( y.getLeft() );

                            y.setParent( nd );

                            if ( nd.getChild() == null ) {
                                nd.setChild( y );
                                y.setRight( y );
                                y.setLeft( y );

                                count+=3;
                            }
                            else {
                                y.setLeft( nd.getChild() );
                                y.setRight( nd.getChild().getRight() );
                                nd.getChild().setRight( y );
                                y.getRight().setLeft( y );

                                count+=9;
                            }

                            nd.increaseDegree();

                            y.setMarked( false );
                            markedNodes++;

                            nodeSequence.set( degree, null );

                            degree++;

                            count+=20;
                        }

                        nodeSequence.set( degree, nd );

                        nd = next;
                        numRoots--;

                        count+=10;
                    }

                    minimumNode = null;

                    for ( Node pointer : nodeSequence ) {
                        if ( pointer == null ) {
                            count++; continue;
                        }

                        if ( minimumNode == null ) {
                            minimumNode = pointer; count++;
                        }

                        pointer.getLeft().setRight(pointer.getRight());
                        pointer.getRight().setLeft(pointer.getLeft());

                        pointer.setLeft(minimumNode);
                        pointer.setRight(minimumNode.getRight());
                        minimumNode.setRight(pointer);
                        pointer.getRight().setLeft(pointer);

                        if (compare(pointer, minimumNode) < 0) {
                            minimumNode = pointer; count++;
                        }

                        count+=16;
                    }

                    count+=14;
                }

                count+=3;
            }

            size--;

            Integer minimum = z.getKey();
            keys.remove( minimum );

            count+=27;

        long end = System.nanoTime();

        TimeAndNumOfOperations result = new TimeAndNumOfOperations(end - begin, count);

        count = 0;

        return result;
    }

}