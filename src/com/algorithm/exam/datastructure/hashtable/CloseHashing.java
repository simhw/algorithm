package com.algorithm.exam.datastructure.hashtable;

// Linear Probing 기법
// Close Hashing 기법 중 하나, 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법이다.
// 충돌이 일어나면, 해당 hash 주소의 다음 주소부터 맨 처음 나오는 빈공간에 저장하는 기법이다.
// 저장공간 활용도를 높이기 위한 기법

public class CloseHashing {
    Slot[] closeHashTable;

    CloseHashing(Integer size) {
        this.closeHashTable = new Slot[size];
    }

    public static class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int)key.charAt(0) % this.closeHashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.closeHashTable[address] != null) {
            // update
            if (this.closeHashTable[address].key == key) {
                this.closeHashTable[address].value = value;
                return true;
            }
            else {
                Integer nextAddress = address + 1;
                while (this.closeHashTable[nextAddress] != null) {
                    // update
                    if (this.closeHashTable[nextAddress].key == key) {
                        this.closeHashTable[nextAddress].value = value;
                        return true;
                    }
                    else {
                        nextAddress++;
                        if (nextAddress >= this.closeHashTable.length)
                            return false;
                    }
                }// end while
                this.closeHashTable[nextAddress] = new Slot(key, value);
                return true;
            }
        }
        else {
            this.closeHashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if (this.closeHashTable[address] != null) {
            if (this.closeHashTable[address].key == key) {
                return this.closeHashTable[address].value;
            }
            else {
                // 예외 케이스로, 키에 해당하는 주소가 가장 마지막 슬롯일 경우,
                // this.hashTable[address + 1] 에 해당하는 배열은 없기 때문에,
                // 예외 케이스에서도 동작하도록 currAddress 는 address 만 대입하고 진행한다.
                Integer nextAddress = address;
                while (this.closeHashTable[nextAddress] != null) {
                    if (this.closeHashTable[nextAddress].key == key) {
                        return this.closeHashTable[nextAddress].value;
                    }
                    else {
                        nextAddress++;
                        if (nextAddress >= this.closeHashTable.length) {
                            return null;
                        }
                    }
                }// end while
                return null;
            }
        }
        else
            return null;
    }

    public static void main(String[] args) {
        CloseHashing closeHashing = new CloseHashing(20);
        closeHashing.saveData("DaveLee", "010-1111-2222");
        closeHashing.saveData("Daisy", "010-2222-3333");
        closeHashing.saveData("Amy", "010-3333-4444");
        closeHashing.saveData("Andy", "010-4444-5555");

        System.out.println(closeHashing.getData("DaveLee"));
        System.out.println(closeHashing.getData("Daisy"));
        System.out.println(closeHashing.getData("Deny"));
        System.out.println(closeHashing.getData("Amy"));
        System.out.println(closeHashing.getData("Andy"));



    }
}