package com.jad;

import java.util.Stack;

public class Links extends Stack<Link> {
    public boolean alreadyExist(Node<?> start, Node<?> end) {
        for(Link link : this) {
            if (link.is(start, end) || link.is(end, start)) {
                return true;
            }
        }
        return false;
    }

    public Links getAllLinksByNode(Node<?> node) {
        Links linksByNode = new Links();
        for (Link link : this) {
            if (link.getStart() == node) {
                linksByNode.add(link);
            }
        }
        return linksByNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Link link : this) {
            result.append(link).append("\n");
        }
        return result.toString();
    }

    public String toStringJustTheEnd() {
        StringBuilder result = new StringBuilder(this.get(0).getStart().getValue() + " : ");
        for (Link link : this) {
            result.append(link.getEnd().getValue()).append("(").append(link.getWeight()).append(") ");
        }
        return result.toString();
    }

    public void descendingSortByWeight() {
        this.sort(Link::compareTo);
    }

    @Override
    public Links clone() {
        super.clone();
        Links clonedLinks = new Links();
        for (Link link : this) {
            clonedLinks.add(link.clone());
        }
        return clonedLinks;
    }

    public void clean() {
        Links linkToRemoved = new Links();
        for (Link link : this) {
            if (link.getStart() == link.getEnd()) {
                linkToRemoved.add(link);
            }
        }
        for (Link link : linkToRemoved) {
            this.remove(link);
        }
    }
}
