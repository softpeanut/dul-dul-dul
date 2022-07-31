package com.myshop.lock;

public class LockData {
    private final String type;
    private final String id;
    private final String lockId;
    private final long timestamp;

    public LockData(String type, String id, String lockId, long timestamp) {
        this.type = type;
        this.id = id;
        this.lockId = lockId;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getLockId() {
        return lockId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isExpired() {
        return timestamp < System.currentTimeMillis();
    }
}