package com.company;

public class IndexRecord {
    private final long startPointer;
    private final long offset;

    public IndexRecord(long startPointer, long offset) {
        this.startPointer = startPointer;
        this.offset = offset;
    }
}
