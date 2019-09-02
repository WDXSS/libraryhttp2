package origin.com.libraryhttp.http.simple.offer.java.enum1;

/**
 * 给 enum 自定义属性和方法
 * 给 enum 对象加一下 value 的属性和 getValue() 的方法
 */
public enum EnumTest2 {
    MON(11), TUE(22), WED(33), THU(44), FRI(5), SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest() {
            return true;
        }
    };

    private int value;

    private EnumTest2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest() {
        return false;
    }
}
