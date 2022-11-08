public class counter {

    protected long count = 0;

    public counter() {
        this.count = 0;
    }

    public counter(long n) {
        this.count = n;

    }

    public void add(long value){
        this.count = this.count + value;
    }

    public long get() {
        return this.count;
    }

}