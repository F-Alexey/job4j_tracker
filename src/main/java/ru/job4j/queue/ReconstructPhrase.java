package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int count = evenElements.size();
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < count; index++) {
            if (index % 2 == 0) {
                builder.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        int count = descendingElements.size();
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < count; index++) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
