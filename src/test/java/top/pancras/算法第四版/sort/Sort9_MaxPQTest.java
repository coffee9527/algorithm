package top.pancras.算法第四版.sort;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by pancras on 2018/5/4 0004.
 */
public class Sort9_MaxPQTest {
    private static PrintStream out = System.out;

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void max() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        Sort9_MaxPQ<String> pq = new Sort9_MaxPQ<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String item = scanner.next();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) out.print(pq.delMax() + " ");
        }
        out.println("(" + pq.size() + " left on pq)");
    }

    @Test
    public void delMax() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
    }

}