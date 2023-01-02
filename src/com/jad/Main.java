package com.jad;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Node<String>> nodes = new ArrayList<>();
        Links links = new Links();

        for (int i = 0; i <= 'I' - 'A'; i++) {
            nodes.add(new Node<>("" + (char) ('A' + i)));
        }
        for (int startIndex = 0; startIndex < nodes.size(); startIndex++) {
            for (int i = 0; i < nodes.size(); i++) {
                int endIndex = new Random().nextInt(nodes.size());
                if (! ((endIndex == startIndex) || links.alreadyExist(nodes.get(startIndex), nodes.get(endIndex)))) {
                    links.add(new Link(new Random().nextInt(10) + 1, nodes.get(startIndex), nodes.get(endIndex)));
                }
            }
        }
        for (Node<String> node : nodes) {
            System.out.println(links.getAllLinksByNode(node).toStringJustTheEnd());
        }

        for (Link link : links) {
            System.out.print(link + ", ");
        }
        System.out.println();
        Links borukvaLinks = Boruvka.get(links);
        for (Link link : borukvaLinks) {
            System.out.print(link + ", ");
        }
        System.out.println();
    }
}
