package com.algorithm.exam.datastructure.hashtable;

// Open Hashing 기법 중 하나, 해쉬 테이블 저장공간 외의 공간을 활용하는 기법
// 충돌이 일어나면, 링크드 리스트라는 자료 구조를 사용해서, 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법이다.

public class OpenHashing {
    Slot[] openHashTable;

    OpenHashing(Integer size){
        this.openHashTable = new Slot[size];
    }

    public static class Slot{
        String key;
        String value;
        Slot next;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        int address = (int)key.charAt(0) % this.openHashTable.length;
        return address;
    }

    public boolean saveData(String key, String value) {
        Integer address = hashFunc(key);
        if (this.openHashTable[address] != null) {
            // head
            Slot findSlot = this.openHashTable[address];
            Slot preSlot = this.openHashTable[address];
            while (findSlot != null){
                // update
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                }
                else {
                    preSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            preSlot.next = new Slot(key, value);
        }
        else {
            this.openHashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = hashFunc(key);
        if (this.openHashTable[address] != null) {
            // head
            Slot findSlot = this.openHashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                }
                else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        }
        else {
            return null;
        }
    }


    public static void main(String[] args){
        OpenHashing openHashing  = new OpenHashing(10);
        openHashing.saveData("DaveLee", "010-1111-2222");
        openHashing.saveData("Daisy", "010-2222-3333");
        openHashing.saveData("Amy", "010-3333-4444");
        openHashing.saveData("Andy", "010-4444-5555");


        System.out.println(openHashing.getData("DaveLee"));
        System.out.println(openHashing.getData("Daisy"));
        System.out.println(openHashing.getData("Deny"));
        System.out.println(openHashing.getData("Amy"));
        System.out.println(openHashing.getData("Andy"));
    }
}
