package SlidingWindowRateLimiter;

import java.time.Instant;
import java.time.temporal.Temporal;

public class Request {

    private Instant timestamp;
    private Integer count;

    public Request(Instant timestamp, Integer count) {
        this.timestamp = timestamp;
        this.count = count;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getCount() {
        return this.count;
    }

    public Temporal getTimestamp() {
        return this.timestamp;
    }
}
