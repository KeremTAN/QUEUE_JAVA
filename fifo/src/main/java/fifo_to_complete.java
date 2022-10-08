import java.util.Arrays;

public class fifo_to_complete {
    public static void main(String[] args) {
        QUEUE queue = new QUEUE();
        int TEST=1;

        QUEUE_ELEMENT fifo;
        char[] str;

        fifo = queue.fifo_new(4);
        TEST *=queue.fifo_push(fifo, "hello".toCharArray());
        TEST *=queue.fifo_push(fifo, "world".toCharArray());
        queue.fifo_dump(fifo);
        queue.fifo_free(fifo);

        fifo = queue.fifo_new(4);
        TEST *=queue.fifo_push(fifo, "elem1".toCharArray());
        TEST *=queue.fifo_push(fifo, "elem2".toCharArray());
        TEST *=queue.fifo_push(fifo, "elem3".toCharArray());
        TEST *=queue.fifo_push(fifo, "elem4".toCharArray());
        queue.fifo_dump(fifo);
        TEST *=queue.fifo_push(fifo, "A".toCharArray());
        queue.fifo_dump(fifo);
        TEST *=queue.fifo_push(fifo, "X".toCharArray());
        TEST *=queue.fifo_push(fifo, "Y".toCharArray());
        TEST *=queue.fifo_push(fifo, "Z".toCharArray());
        TEST *=queue.fifo_push(fifo, "T".toCharArray());
        TEST *=(1+queue.fifo_push(fifo, "U".toCharArray()));
        queue.fifo_dump(fifo);
        queue.fifo_free(fifo);

        fifo = queue.fifo_new(4);
        TEST*=queue.fifo_push(fifo, "elem1".toCharArray());
        TEST*=queue.fifo_push(fifo, "elem2".toCharArray());
        TEST*=queue.fifo_push(fifo, "elem3".toCharArray());
        TEST*=queue.fifo_push(fifo, "elem4".toCharArray());
        queue.fifo_free(fifo);

        fifo = queue.fifo_new(4);
        TEST*=queue.fifo_push(fifo, "elem1".toCharArray());
        TEST*=queue.fifo_push(fifo, "elem2".toCharArray());
        str = queue.fifo_pull(fifo);
        TEST*= Arrays.equals(str, "elem1".toCharArray()) ? 1 : 0;
        str=null;
        TEST*=queue.fifo_push(fifo, "elem3".toCharArray());
        TEST*=queue.fifo_push(fifo, "elem4".toCharArray());
        str = queue.fifo_pull(fifo);
        TEST*= Arrays.equals(str, "elem2".toCharArray()) ? 1 : 0;
        str=null;
        str = queue.fifo_pull(fifo);
        TEST*= Arrays.equals(str, "elem3".toCharArray()) ? 1 : 0;
        str=null;
        str = queue.fifo_pull(fifo);
        TEST*= Arrays.equals(str, "elem4".toCharArray()) ? 1 : 0;
        str=null;
        queue.fifo_free(fifo);

        if (TEST==0)
            System.out.println("TEST FAILED");
    }
}
