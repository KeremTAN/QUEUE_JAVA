public class QUEUE {
    QUEUE_ELEMENT fifo_new(int size){
        QUEUE_ELEMENT new_fifo = new QUEUE_ELEMENT();
        new_fifo.size=size;
        new_fifo.produce=new_fifo.consume=-1;
        new_fifo.empty=0;
        new_fifo.contents=new char[size][];
        return  new_fifo;
    }
    void fifo_free(QUEUE_ELEMENT fifo) {
        for(int i=0; i<(fifo.size); i++)
            fifo.contents[i]=null;
        fifo=null;
    }
    int fifo_push(QUEUE_ELEMENT fifo, char[] str) {
        if(fifo.produce==(fifo.size-1)){
            return 0;
        }
        else{
            fifo.empty=1;
            fifo.produce+=1;
            fifo.contents[fifo.produce]=new char[str.length];
            fifo.contents[fifo.produce]=str;
            return 1;
        }
    }
    char[] fifo_pull(QUEUE_ELEMENT fifo) {
        if(fifo.consume==fifo.produce){
            fifo.empty=0;
            fifo.consume=fifo.produce=-1;
            return null;
        }
        else{
            fifo.consume++;
            char[] consumedString = fifo.contents[fifo.consume];
            fifo.contents[fifo.consume]=null;
            return consumedString;
        }
    }
    void fifo_dump(QUEUE_ELEMENT fifo) {
        char[] str=fifo_pull(fifo);
        while(str!=null) {
            System.out.println(str);
            str=fifo_pull(fifo);
        }
    }
}