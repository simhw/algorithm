package com.algorithm.exam.datastructure;

// 해쉬 테이블(Hash Table)
// 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조이다.
public class HashTable {
    // String[] hashTable;
    Slot[] hashTable;

    HashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    // 슬롯(Slot)
    // 해쉬 테이블에서 한 개의 데이터를 저장할 수 있는 공간이다.
    public class Slot {
        private String value;

        Slot(String value) {
            this.value = value;
        }
    }


    // 해쉬 함수(Hash function)
    public int hashFunc(String key) {
        // Division 기법
        // 가장 간단한 해쉬 함수 중 하나로, 나누기를 통해, 나머지 값을 사용하는 기법이다.
        int address = (int)key.charAt(0) % this.hashTable.length;
        return address;

    }

    // 데이터를 저장하는 메서드
    public boolean saveData(String key, String value) {
        int address = hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        }
        else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }
    // key 에 대한 데이터를 가져오는 메서드
    public String getData(String key){
        String value = this.hashTable[hashFunc(key)].value;
        if (value != null){
            return value;
        }
        else
            return null;

    }

    public static void main(String args[]){

        HashTable hashTable = new HashTable(10);
        hashTable.saveData("DaveLee", "010-1111-2222");
        hashTable.saveData("HyunShim", "010-2222-3333");

        System.out.println(hashTable.getData("HyunShim"));
        System.out.println(hashTable.getData("DaveShim"));
        System.out.println(hashTable.getData("AmyShim"));
    }
}
