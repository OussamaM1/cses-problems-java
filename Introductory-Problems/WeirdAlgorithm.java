import java.util.*;
import java.io.*;

public class WeirdAlgorithm {
    static PrintWriter out;
    static Reader in;

    public static void main(String[] args) throws IOException {
        // in = new Reader(new FileInputStream(args[0])); // test.
        input_output();
        WeirdAlgorithm solver = new WeirdAlgorithm();
        solver.solve();
        out.close(); // remove test.
        out.flush(); // remove test.
    }

    static long INF = (long) 1e16;
    static int maxn = (int) 1e5 + 5;
    static int mod = (int) 1e9 + 7;

    void solve() throws IOException {
        long n = in.nextLong();
        String ans = "";
        if (n == 1) {
            System.out.println("1");
            return;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                ans += n + " ";
                n /= 2;
            } else {
                ans += n + " ";
                n = n * 3 + 1;
            }
        }
        System.out.println(ans.trim() + " 1");
    }

    static class Reader {

        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream is) {
            mIs = is;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();

            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }

    static void input_output() throws IOException {
        File f = new File("hello.in");
        if (f.exists() && !f.isDirectory()) {
            in = new Reader(new FileInputStream("hello.in"));
        } else
            in = new Reader();
        f = new File("out.txt");
        if (f.exists() && !f.isDirectory()) {
            out = new PrintWriter(new File("out.txt"));
        } else
            out = new PrintWriter(System.out);
    }
}
