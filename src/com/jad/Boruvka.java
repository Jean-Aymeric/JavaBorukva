package com.jad;

import java.util.Hashtable;
import java.util.Map;

public abstract class Boruvka {
    public static Links get(Links links) {
        Hashtable<Node<?>, Node<?>> mergableNodes = getMergableNodesFromLinks(links);
        Links clonedLinks = links.clone();
        Links borukvaLinks = new Links();
        clonedLinks.descendingSortByWeight();
        while (mergableNodes.values().stream().distinct().count() > 1) {
            Link smallestLink = clonedLinks.pop();
            Node<?> mergedNode1 = mergableNodes.get(smallestLink.getStart());
            Node<?> mergedNode2 = mergableNodes.get(smallestLink.getEnd());
            if (mergedNode1 != mergedNode2) {
                borukvaLinks.add(smallestLink);
                for (Map.Entry<Node<?>, Node<?>> entry : mergableNodes.entrySet()) {
                    if (mergableNodes.get(entry.getKey()) == mergedNode2) {
                        mergableNodes.replace(entry.getKey(), mergedNode1);
                    }
                }
            }
            clonedLinks.clean();
        }
        return borukvaLinks;
    }

    private static Hashtable<Node<?>, Node<?>> getMergableNodesFromLinks(Links links) {
        Hashtable<Node<?>, Node<?>> mergableNodes = new Hashtable<>();
        for (Link link : links) {
            if (! mergableNodes.containsKey(link.getStart())) {
                mergableNodes.put(link.getStart(), link.getStart());
            }
            if (! mergableNodes.containsKey(link.getStart())) {
                mergableNodes.put(link.getEnd(), link.getEnd());
            }
        }
        return mergableNodes;
    }
}
