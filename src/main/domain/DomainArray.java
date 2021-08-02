package main.domain;

public class DomainArray<T extends Object> {
    public int length;
    protected int size;
    transient Object[] data;

    public DomainArray(int size) {
        this.length = 0;
        this.size = size;
        this.data = new Object[size];
    }

    public void add(T element) {
        if (this.length +1 == this.size) {
            Object[] newData = new Object[this.size * 2];
            for (int i =0; i< this.size; i++) {
                newData[i] = this.data[i];
            }

            this.data = newData;
            this.size = this.size * 2;
        }

        this.data[this.length] = element;
        this.length += 1;

    }

    public T get(int index) {
        return (T) this.data[index];
    }

    public T pop() {
        if (this.length  ==0 ) {
            return null;
        }
        Object[] newData = new Object[this.length  - 1];
        for (int i = newData.length -1 ; i >= 0; i--) {
            newData[i] = this.data[i];
        }
        Object data = this.data[this.length-1];
        this.length = newData.length;
        this.data = newData;
        return (T) data;
    }

    public T delete(int index) {
        if (index < 0 || index > this.length -1) {
            return null;
        }

        Object dataToReturn = this.data[index];
        this.shiftItems(index);
        return (T) dataToReturn;
    }

    private void shiftItems(int index) {
        Object[] newDataContainer = new Object[this.length -1];
        for (int i = 0; i <this.length; i++) {
            if (i != index) {
                if (i > index) {
                    newDataContainer[i - 1] = this.data[i];
                } else {
                    newDataContainer[i] = this.data[i];
                }
            }
        }
        atomicReplace(newDataContainer);
    }

    private void atomicReplace(Object[] newDataContainer) {
        synchronized (this) {
            this.data = newDataContainer;
            this.length--;
        }
    }
}
