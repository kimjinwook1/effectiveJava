# try-finally보다는 try-with-resources를 사용하라

```java
    public static String firstLineOfFile (String path)throw IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                return br.readLine();
            } finally {
                br.close();
            }
    }
```
자원이 둘 이상이면 try-finally 방식은 너무 지저분하다!

```java
        public static void copy(String src, String dst) throws IOException {
            InputStream in = new FileInputStream(src);
            try {
                OutputStream out = new FileOutputStream(dst);
                try {
                    byte[] buf = new byte[BUFFER_SIZE];
                    int n;
                    while ((n = in.read(buf)) >= 0)
                        out.write(buf, 0, n);
                } finally {
                    out.close();
                }
            } finally {
                in.close();
            }
        }
```

try-with-resources 구조를 사용하려면 해당 자원이 AutoCloseable 인터페이스를 구현해야한다.
(AutoCloseable: 단순히 void를 반환하는 close 메서드 하나만 정의한 인터페이스다.)
닫아야 하는 자원을 뜻하는 클래스를 작성한다면 AutoCloseable을 반드시 구현해야 한다.

try-with-resources를 사용하면 놓치기 쉬운 자원 닫기를 해결할 수 있다.
