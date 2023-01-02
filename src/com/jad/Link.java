package com.jad;

public class Link implements Comparable<Link>{
    private final int weight;
    private final Node<?> start;
    private final Node<?> end;

    public Link(final int weight, final Node<?> start, final Node<?> end) {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public Link(Link link) {
        this(link.getWeight(), link.getStart(), link.getEnd());
    }

    public int getWeight() {
        return weight;
    }

    public Node<?> getStart() {
        return start;
    }

    public Node<?> getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return this.start.getValue() + "-" + this.end.getValue() + "(" + this.getWeight() + ")";
    }

    public boolean is(Node<?> start, Node<?> end) {
        return (this.start == start) && (this.end == end);
    }

    @Override
    public int compareTo(final Link linkToCompare) {
        return Integer.compare(linkToCompare.getWeight(), this.getWeight());
    }

    public Link clone() {
        return new Link(this);
    }
}
