package com.codingtest.exam.datastructure.Tree;
// 트리 (Tree) 구조
// 트리: Node 와 Branch 를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조이다.

// 이진 트리와 이진 탐색 트리 (Binary Search Tree)
// 이진 트리: 노드의 최대 Branch 가 2인 트리이다.
// 이진 탐색 트리 (Binary Search Tree, BST): 이진 트리에 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지는 조건이 있는 트리이다.

public class NodeMgmt {
    Node head = null;

    public boolean insertNode(int data) {
        // CASE1: 노드가 하나도 없을 경우
        if (this.head == null) {
            this.head = new Node(data);
        }
        // CASE2: 노드가 하나 이상 있을 경우
        else {
            Node findNode = this.head;
            while (true) {
                // CASE2-1: 현재 노드의 왼쪽에 노드가 들어가야 할 경우
                if (findNode.data > data) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    }
                    else {
                        findNode.left = new Node(data);
                        break;// end loop
                    }
                }
                // CASE2-2: 현재 노드의 오른쪽에 노드가 들어가야 할 경우
                else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    }
                    else {
                        findNode.right = new Node(data);
                        break;// end loop
                    }
                }
            }// end while
        }
        return true;
    }

    public Node searchNode(int data) {
        // CASE1: Node 가 하나도 없을 경우
        if (this.head == null) {
            return null;
        }
        // CASE2: Node 가 하나 이상 있을 경우
        else {
            // Root Node
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.data == data) {
                    return findNode;
                }
                else {
                    if (findNode.data > data) {
                        findNode = findNode.left;
                    }
                    else {
                        findNode = findNode.right;
                    }
                }
            }// end while
        }return null;
    }

    public boolean deleteNode(int data) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 예외)
        // CASE0-1: Node 가 하나도 없을 경우
        if (this.head == null) {
            return false;
        }
        else {
            // CASE0-2: Node 가 단지 하나이고, 해당 Node 삭제 할 경우
            if (this.head.data == data && this.head.left == null && this.head.right == null) {
                System.out.println("CASE0-2");
                this.head = null;
                return true;
            }
            while (currNode != null) {
                if (currNode.data == data) {
                    searched = true;
                    break;
                }
                else if (currNode.data > data) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                }
                else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }// end while
            if (searched == false)
                return false;
        }
        // searched 가 true 인 경우
        // 삭제할 Node 가 있을 경우

        // Case1: 삭제할 Node 가 Leaf Node 인 경우
        // 삭제할 Node 의 Parent Node 가 삭제할 Node 를 가리키지 않도록 한다.
        if (currNode.left == null && currNode.right == null) {
            System.out.println("Case1");
            if (data < currParentNode.data) {
                currParentNode.left = null;
                currNode = null;
            }
            else {
                currNode.right = null;
                currNode = null;
            }
            return true;
        }
        // Case2: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우
        // 삭제할 Node 의 Parent Node 가 삭제할 Node 의 Child Node 를 가리키도록 한다.

        // Case2-1: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우 (왼쪽에 Child Node 가 있을 경우)
        else if (currNode.left != null && currNode.right == null) {
            System.out.println("Case2-1");
            if (currParentNode.data > data) {
                currParentNode.left = currNode.left;
                currNode = null;
            }
            else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        }
        // Case2-2: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우 (오른쪽에 Child Node 가 있을 경우)
        else if (currNode.left == null && currNode.right != null) {
            System.out.println("Case2-2");
            if (currParentNode.data > data) {
                currParentNode.left = currNode.right;
                currNode = null;
            }
            else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        }
        // CASE3: Child Node 가 두 개인 Node 삭제
        // 1. 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node 의 Parent Node 가 가리키도록 한다.
        // 2. 삭제할 Node 의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node 의 Parent Node 가 가리키도록 한다.
        else {
            // CASE3-1: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 경우)
            if (currParentNode.data > data) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode;
                while (changeNode.left != null){
                    changeNode = changeNode.left;
                    changeParentNode = changeParentNode.right;
                }
                // changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서, 가장 작은 값을 가진 Node 이다.
                // Case3-1-1: changeNode 의 Child Node 가 없을 경우
                if (changeNode.right == null) {
                    System.out.println("Case3-1-1");
                    changeParentNode.left = null;
                }
                // Case3-1-2: changeNode 의 오른쪽 Child Node 가 있을 경우
                else {
                    System.out.println("Case3-1-2");
                    changeParentNode.left = changeNode.right;
                }
                // 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node 의 Parent Node 가 가리키도록 한다.
                currParentNode.left = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
                currNode = null;
            }
            // CASE3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 오른쪽에 있을 때)
            else{
                System.out.println("Case3-2");
                Node changeNode = currNode.right;
                Node changeParentNode = currNode;
                while (changeNode.left != null){
                    changeNode = changeNode.left;
                    changeParentNode = changeParentNode.right;
                }
                if (changeNode.right == null) {
                    changeParentNode.left = null;
                }
                // Case3-1-2: changeNode 의 오른쪽 Child Node 가 있을 경우
                else {
                    System.out.println("Case3-1-2");
                    changeParentNode.left = changeNode.right;
                }
                // 삭제할 Node 의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node 의 Parent Node 가 가리키도록 한다.
                currParentNode.right = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
                currNode = null;

            }
        }return true;
    }

    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);

        System.out.println(myTree.deleteNode(16));
        System.out.println("HEAD: " + myTree.head.data);
        System.out.println("HEAD LEFT: " + myTree.head.left.data);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.data);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.data);

        System.out.println("HEAD RIGHT: " + myTree.head.right.data);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.data);
        System.out.println("HEAD RIGHT LEFT LEFT: " + myTree.head.right.left.left.data);
        System.out.println("HEAD RIGHT LEFT RIGHT: " + myTree.head.right.left.right.data);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.data);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.data);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.data);


    }
}
