package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> root = findBy(parent);
        if (root.isPresent()) {
            if (!root.get().children.contains(child)) {
                root.get().children.add(new Node(child));
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(p -> p.value.equals(value));
    }

    public boolean isBinary() {
        Optional<Node<E>> rsl = findByPredicate(p -> p.children.size() > 2);
        if (rsl.isPresent()) {
            return false;
        }
        return true;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
