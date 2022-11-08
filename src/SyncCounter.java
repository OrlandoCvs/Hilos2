public class SyncCounter {
    protected long count = 0;

    public SyncCounter() {
        this.count = 0;
    }

    public SyncCounter(long n) {
        this.count = n;

    }

    public synchronized void add(long value) {
        //synchronized (this) {
        this.count = this.count + value;
        // }
    }

    public long get() {
        return this.count;
    }

}
