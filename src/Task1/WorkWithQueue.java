package Task1;

import java.util.Objects;

public class WorkWithQueue {

    // Указатель на первый элемент
    private ObjectBox head = null;
    // Указатель на последний элемент
    private ObjectBox tail = null;
    // Поле для хранения размера очереди
    private int size = 0;

    public void push(Object obj) {
        // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
        // Если очередь пустая - в ней еще нет элементов
        if (head == null) {
            // Теперь наша голова указывает на наш первый элемент
            head = ob;
        } else {
            // Если это не первый элемент, то надо, чтобы последний элемент в очереди
            // указывал на вновь прибывший элемент
            tail.setNext(ob);
        }
        // И в любом случае нам надо наш "хвост" переместить на новый элемент
        // Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент
        tail = ob;
        // Увеличиваем размер нашей очереди
        size++;
    }

    public Object pull() {
        // Если у нас нет элементов, то возвращаем null
        if (size == 0) {
            return null;
        }
        // Получаем наш объект из вспомогательного класса из "головы"
        Object obj = head.getObject();
        // Перемещаем "голову" на следующий элемент
        head = head.getNext();
        // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        if (head == null) {
            tail = null;
        }
        // Уменьшаем размер очереди
        size--;
        // Возвращаем значение
        return obj;
    }

    public int size() {
        return size;
    }

    public Object pollFirst(){
        if(size == 0) {
            return null;
        }
        else{
            Object obj = head;
            head.setNext(head.getNext());
            return obj;
        }

    }

    public int findObjectIndex(Object object){
        int systemError = 0;
        int index = -1;
        if (size == 0){
            return index;
        }
        ObjectBox current = head;
        Object headElement = current.getObject();
        Object tailElement = tail.getObject();
        while(!headElement.equals(object) && index<size-1){
            if(index < size-2){
                current = head.getNext();
                headElement = current.getObject();
            }
            else{
                if(tailElement.equals(object)){
                    break;
                }
                else{
                    systemError = 1;
                }
            }
            index++;
        }
        if(systemError == 0) {
            index++;
            return index;
        }
        else{
            return 0;
        }
    }

    // Наш вспомогательный класс будет закрыт от посторонних глаз
    private class ObjectBox {
        // Поле для хранения объекта
        private Object object;
        // Поле для указания на следующий элемент в цепочке.
        // Если оно равно NULL - значит это последний элемент
        private ObjectBox next;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkWithQueue that = (WorkWithQueue) o;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }
}
