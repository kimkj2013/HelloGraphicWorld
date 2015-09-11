class Wave {

  private static char[] s = "----------------------------------------------------------------------".toCharArray();

  private static int cx = 0;

  public static void main(String[] args) throws Exception {
    while (true) {
      if (cx < s.length) {
        s[cx] = '/';
        System.out.println(arrToStr(s));
        cx++;
        Thread.sleep(10);
      }
      else {
        s[cx - s.length] = '-';
        System.out.println(arrToStr(s));
        if (cx < 2 * s.length - 1) cx++;
        else cx = 0;
        Thread.sleep(10);
      }
    }
  }

  public static String arrToStr(char[] s) {
    String k = "";
    for (char c : s) {
      k += "" + c;
    }
    return k;
  }
}
