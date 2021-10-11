package com.codingtest.exam.datastructure.heap;
// 힙: 데이터에서 최대값과 최소값을 빠르게 찾기 위해 고안된 완전 이진 트리(Complete Binary Tree)
//
import java.util.ArrayList;
import java.util.Collections;
public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap () {
        heapArray = new ArrayList<Integer>();
        heapArray.add(null);
    }

    public boolean move_up(int inserted_idx) {
        if (inserted_idx <= 1) {
            return false;
        }
        int parent_idx = inserted_idx / 2;

        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) return true;
        else return false;
    }

    public boolean move_down(int popped_idx) {
        int left_child_idx = popped_idx * 2;
        int right_child_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 경우(자식 노드가 하나도 없을 경우)
        if (left_child_idx >= this.heapArray.size()) {
            return false;
        }
        // CASE2: 오른쪽 자식 노드만 없을 경우
        else if (right_child_idx >= this.heapArray.size()) {
            if (this.heapArray.get(left_child_idx) > this.heapArray.get(popped_idx))
                return true;
            else return false;
        }
        // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
        else {
            if (this.heapArray.get(left_child_idx) >= this.heapArray.get(right_child_idx)) {
                if (this.heapArray.get(left_child_idx) > this.heapArray.get(popped_idx)) {
                    return true;
                } else return false;
            }
            else {
                if (this.heapArray.get(right_child_idx) > this.heapArray.get(popped_idx)) {
                    return true;
                } else return false;
            }
        }
    }

    public boolean insertNode(Integer data) {
        if (heapArray == null) {
            System.out.println("null");
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        else {
            int inserted_idx, parent_idx;
            this.heapArray.add(data);

            inserted_idx = this.heapArray.size() - 1;
            while (this.move_up(inserted_idx)) {
                parent_idx = inserted_idx / 2;
                Collections.swap(this.heapArray, inserted_idx, parent_idx);
                inserted_idx = parent_idx;
            }
            return true;
        }

    }

    // 보통 삭제는 최상단 노드 (root 노드)를 삭제하는 것이 일반적이다.
    // 힙의 용도는 최대값 또는 최소값을 root 노드에 놓아서, 최대값과 최소값을 바로 꺼내 쓸 수 있도록 하는 것이다.
    // 상단의 데이터 삭제시, 가장 최하단부 왼쪽에 위치한 노드 (일반적으로 가장 마지막에 추가한 노드) 를 root 노드로 이동한다.
    // root 노드의 값이 child node 보다 작을 경우, root 노드의 child node 중 가장 큰 값을 가진 노드와 root 노드 위치를 바꿔주는 작업을 반복한다. (swap)
    public Integer popNode() {
        Integer returned_data;
        int popped_idx, left_child_idx, right_child_idx;

        if (this.heapArray == null) {
            return null;
        }
        else {
            returned_data = this.heapArray.get(1);  // root
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while (this.move_down(popped_idx)) {
                left_child_idx = popped_idx * 2;
                right_child_idx = popped_idx * 2 + 1;
                // CASE2: 오른쪽 자식 노드만 없을 경우
                if (this.heapArray.size() <= right_child_idx) {
                        Collections.swap(this.heapArray, popped_idx, left_child_idx);
                        popped_idx = left_child_idx;
                }
                // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
                else {
                    if (this.heapArray.get(left_child_idx) >= this.heapArray.get(right_child_idx)) {
                       Collections.swap(this.heapArray, popped_idx, left_child_idx);
                       popped_idx = left_child_idx;
                    }
                    else {
                        Collections.swap(this.heapArray, popped_idx, right_child_idx);
                        popped_idx = right_child_idx;
                    }
                }
            }
            return returned_data;
        }
    }
    public static void main(String[] args) {
        Heap heapTest = new Heap();
        heapTest.insertNode(15);
        heapTest.insertNode(10);
        heapTest.insertNode(8);
        heapTest.insertNode(5);
        heapTest.insertNode(4);
        heapTest.insertNode(20);
        System.out.println(heapTest.heapArray);

        heapTest.popNode();
        System.out.println(heapTest.heapArray);
        heapTest.popNode();
        System.out.println(heapTest.heapArray);

    }
}